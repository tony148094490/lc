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

	public List<Integer> minCoverWithSCC(Map<Integer, Set<Integer>> graph) {
		
		// construct sccs
		List<SCC> sccs = findSCCs(graph);
																	//	  <- 
		// we cannot just get one from each scc because we may have 1 -> 2 ->3 where 2 and 3 forms one scc and 1 itself is scc, and the result should be just 1, instead of 1 and 2(or3)

		// connect sccs, very naive...
		Map<SCC, Set<SCC>> sccMap = new HashMap<>();
		for(int i = 0 ; i < sccs.size(); i++) {
			sccMap.put(sccs.get(i), new HashSet<>());
			for(int j = 0 ; j < sccs.size(); j++) {
				if(i == j) continue;
				if(isNext(sccs.get(i), sccs.get(j), graph)) {
					sccMap.get(sccs.get(i)).add(sccs.get(j));
				}
			}
		}
		
		
		// toplo sort sccMap
		Stack<SCC> stack = new Stack<SCC>();
		Set<SCC> visited = new HashSet<>();
		for(SCC scc : sccMap.keySet()) {
			getSCCOrder(sccMap, stack, visited, scc);
		}

		List<Integer> finalResult = new ArrayList<>();
		while(!stack.isEmpty()) {
			SCC scc = stack.pop();
			if(!visited.contains(scc)) continue;
			
			// get one scc into result
			int nr = scc.nodes.iterator().next();
			finalResult.add(nr);
			removeNextSCCs(sccMap, scc, visited);
		}
		
		// so tedious...
		return finalResult;
	}
	
	private void removeNextSCCs(Map<SCC, Set<SCC>> sccMap, SCC scc, Set<SCC> visited) {
		if(!visited.contains(scc)) return;
		visited.remove(scc);
		for(SCC s : sccMap.get(scc)) {
			removeNextSCCs(sccMap, s, visited);
		}
	}
	
	private void getSCCOrder(Map<SCC, Set<SCC>> map, Stack<SCC> stack, Set<SCC> visited, SCC cur) {
		if(visited.contains(cur)) return;
		visited.add(cur);
		for(SCC next : map.get(cur)) getSCCOrder(map, stack, visited, next);
		stack.push(cur);
	}
	
	private boolean isNext(SCC a, SCC b, Map<Integer, Set<Integer>> graph) {
		for(Integer x : a.nodes) {
			for(Integer graphNext : graph.get(x)) {
				if(b.nodes.contains(graphNext)) return true;
			}
		}
		return false;
	}
	
	private List<SCC> findSCCs(Map<Integer, Set<Integer>> graph) {
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		
		for(Integer k : graph.keySet()) {
			if(!visited.contains(k))
			dfs(graph, visited, stack, k);	
		}
		
		List<SCC> res = new ArrayList<>();
		
		Map<Integer, Set<Integer>> reversedGraph = reverseGraph(graph);
		visited = new HashSet<>();
		while(!stack.isEmpty()) {
			int newVert = stack.pop();
			if(!visited.contains(newVert)) {
				SCC scc = new SCC(newVert);
				getSCC(newVert, visited, reversedGraph, scc);
				res.add(scc);
			}
		}
		return res;
	}
	
	private void dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, Stack<Integer> stack, int k) {
		if(visited.contains(k)) return;
		visited.add(k);
		for(Integer next : graph.get(k)) dfs(graph, visited, stack, next);
		stack.push(k);
	}
	
	private void getSCC(int start, Set<Integer> visited, Map<Integer, Set<Integer>> reversedGraph, SCC scc) {
			if(visited.contains(start)) return;
			visited.add(start);
			scc.nodes.add(start);
			for(Integer next : reversedGraph.get(start)) getSCC(next, visited, reversedGraph, scc);
	}
	
	
	private Map<Integer, Set<Integer>> reverseGraph(Map<Integer, Set<Integer>> graph) {
		Map<Integer, Set<Integer>> res = new HashMap<>();
		for(Integer x : graph.keySet()) {
			res.putIfAbsent(x, new HashSet<>());
			for(Integer y : graph.get(x)) {
				res.putIfAbsent(y, new HashSet<>());
				res.get(y).add(x);
			}
		}
		return res;
	}
	
	public class SCC {
		Set<Integer> nodes;
		public SCC(int value) {
			nodes = new HashSet<>();
			nodes.add(value);
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
		//graph.get(3).add(4);
		graph.get(4).add(3);
		graph.get(4).add(5);
		graph.get(5).add(6);
		graph.get(6).add(4);

		System.out.println(x.minCoverWithSCC(graph));
	}
}


