package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

// https://tinyurl.com/ydd2bg53
/*
 * 考虑我们现在有一个有向图，然后我们现在要选某些点使得整个图的所有点都被碰到。
那我们做过了SCC代表了什么？做了SCC代表的其实是一个缩点的动作，今天假如有a, b, c三个点要选，
但是我做了SCC之后他们被合并成一个S，那就是说其实a,b,c三个点里面 我只要选一个就好了
那我们做完了SCC之后，我们就得到了一个有向的拓朴图
我们找这些拓朴图里面in-degree=0的就行了。因为in-degree=0代表的就是说，这个点没有人碰的到，你必选。
而in-degree > 0的就是说，我前面有人被选过了，至少会有人碰到我，我就能直接满足我缩点后整个集合里面的点，再往下碰这样。

http://acm.hdu.edu.cn/showproblem.php?pid=1827
https://www.youtube.com/watch?v=RpgcYiky7uw (tushar :D)
 */
public class LeastNumberOfNodesToCoverWholeGraph {
	// steps: 1) find sccs 2) connect sccs 3) topo sccs 4) get one of each from scc

	public List<Integer> minCoverWithSCC(Map<Integer,Set<Integer>> graph) {
		List<SCC> sccs = findSCCs(graph);
		System.out.println(sccs);
		Map<SCC, Set<SCC>> map = connect(sccs, graph);
		Stack<SCC> stack = new Stack<>();
		Set<SCC> visited = new HashSet<>();
		for(SCC scc : map.keySet()) {
			dfs(map, scc, visited, stack);
		}

		List<Integer> res = new ArrayList<>();
		while(!stack.isEmpty()) {
			SCC cur = stack.pop();
			if(!visited.contains(cur)) continue;
			res.add(cur.members.iterator().next());
			explore(map, visited, cur);
		}
		return res;
	}

	private void explore(Map<SCC, Set<SCC>> map, Set<SCC> visited, SCC cur) {
		if(!visited.contains(cur)) return;
		visited.remove(cur);
		for(SCC scc : map.get(cur)) explore(map, visited, scc);
	}

	private void dfs(Map<SCC, Set<SCC>> map, SCC cur, Set<SCC> visited, Stack<SCC> stack) {
		if(visited.contains(cur)) return ;
		visited.add(cur);
		for(SCC scc : map.get(cur)) {
			dfs(map, scc, visited, stack);
		}
		stack.push(cur);
	}

	private Map<SCC, Set<SCC>> connect(List<SCC> list, Map<Integer, Set<Integer>> graph) {
		Map<SCC, Set<SCC>> map = new HashMap<>();
		for(int i = 0 ; i < list.size(); i++) {
			map.putIfAbsent(list.get(i), new HashSet<>());
			for(int j = 0 ; j < list.size(); j++) {
				map.putIfAbsent(list.get(j), new HashSet<>());
				if(i == j) continue;
				SCC a = list.get(i);
				SCC b = list.get(j);
				for(int x : a.members) {
					for(int y : b.members) {
						if(graph.containsKey(x) && graph.get(x).contains(y)) {
							map.get(a).add(b);
						}
					}
				}
			}
		}
		return map;
	}

	private List<SCC> findSCCs(Map<Integer, Set<Integer>> graph) {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		for(int x : graph.keySet()) {
			dfs(graph, x, visited, stack);
		}
		Map<Integer, Set<Integer>> reversed = reverse(graph);
		List<SCC> res = new ArrayList<>();
		visited = new HashSet<>();
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			if(visited.contains(cur)) continue;
			SCC scc = new SCC(cur);
			explore(reversed, cur, visited, scc);
			res.add(scc);
		}
		return res;
	}

	private void explore(Map<Integer, Set<Integer>> map, int cur, Set<Integer> visited, SCC scc) {
		if(visited.contains(cur)) return;
		visited.add(cur);
		for(int x : map.get(cur)) {
			explore(map, x, visited, scc);
		}
		scc.members.add(cur);
	}

	private void dfs(Map<Integer, Set<Integer>> map, int cur, Set<Integer> visited, Stack<Integer> stack) {
		if(visited.contains(cur)) return;
		visited.add(cur);
		for(int x : map.get(cur)) {
			dfs(map, x, visited, stack);
		}
		stack.push(cur);
	}

	private Map<Integer, Set<Integer>> reverse(Map<Integer, Set<Integer>> map) {
		Map<Integer, Set<Integer>> res = new HashMap<>();
		for(int x : map.keySet()) {
			res.putIfAbsent(x, new HashSet<>());
			for(int y : map.get(x)) {
				res.putIfAbsent(y, new HashSet<>());
				res.get(y).add(x);
			}
		}
		return res;
	}

	public class SCC {
		Set<Integer> members;
		public SCC(int initial) {
			members = new HashSet<>();
			members.add(initial);
		}
		
		public String toString() {
			String res = "";
			for(int x : members) res += x + ",";
			return res;
		}
	}
	
	public static void main(String[] args) {
		LeastNumberOfNodesToCoverWholeGraph x = new LeastNumberOfNodesToCoverWholeGraph();
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		graph.put(1, new HashSet<>());
		graph.put(2, new HashSet<>());
		graph.put(3, new HashSet<>());
		graph.put(4, new HashSet<>());
		graph.put(5, new HashSet<>());
		graph.put(6, new HashSet<>());
		graph.get(1).add(2);
		graph.get(2).add(3);
		graph.get(3).add(1);
		graph.get(3).add(4);
		graph.get(4).add(3);
		graph.get(4).add(5);
		graph.get(5).add(6);
		graph.get(6).add(4);

		System.out.println(x.minCoverWithSCC(graph));
	}
}


