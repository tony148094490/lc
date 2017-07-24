package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**A->B, 100,
B->C, 100,
A->C, 500.
 *
 */
// 给很多 tuple <depart city, dest city, cost> 代表flight, 找出 给订 city A, city B, maxStops, 最小cost的path. 这题其实简单...
// 可是刚开始竟然说 A* ....讨论了一阵子, 其实DFS就可解....只能怪自己  

// dfs ?
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=215824
/*
 * http://www.1point3acres.com/bbs/thread-220456-1-1.html
 * http://www.1point3acres.com/bbs/thread-214574-1-1.html
 *  第二轮：输入是flight ticket list，每一项包括departure, arrival, cost，然后给一个整数k, 表示最多允许k次中转。给定起始地点A，到达地点B, 要求输出从A到B的最小花费，最多k次中转。
 */
public class MinCostFlightsWithKConnections {
	List<String> path = new ArrayList<>();
	int cost = Integer.MAX_VALUE;
	
	public List<String> getPath(String departure, String destination, int maxStops, Map<String, Map<String, Integer>> flights) {
		List<String> curPath = new ArrayList<>();
		curPath.add(departure);
		dfs(departure, destination, maxStops, flights, curPath, 0);
		return path;
	}
	
	private void dfs(String departure, String destination, int maxStops, Map<String, Map<String, Integer>> map, List<String> curPath, int curCost) {
		if(curPath.size() - 1 > maxStops) return;
		if(curCost > cost) return; // assumption, the total cost of all flights should be less than MAX_VALUE
		
		if(departure.equals(destination)) {
			if(curCost < cost) {
				path = new ArrayList<>(curPath);
			} else if(curCost == cost) { // i added this myself, in case of equal cost, break the tie by least connections winning it
				if(path.size() > curPath.size()) path = new ArrayList<>(curPath);
			}
			return;
		}

		Map<String, Integer> nextStops = map.get(departure);
		for(String str : nextStops.keySet()) {
			curPath.add(str);
			dfs(str, destination, maxStops, map, curPath, curCost + nextStops.get(str));
			curPath.remove(curPath.size()-1);
		}
	}

	
	public static void main(String[] args) {
		Map<String, Map<String, Integer>> flights = new HashMap<>();
		flights.put("A", new HashMap<>());
		flights.put("B", new HashMap<>());
		flights.put("C", new HashMap<>());
		flights.put("D", new HashMap<>());
		flights.put("E", new HashMap<>());
		flights.put("F", new HashMap<>());
		flights.put("G", new HashMap<>());
		flights.get("A").put("G", 1000);
		flights.get("A").put("B", 100);
		flights.get("A").put("E", 50);
		flights.get("B").put("C", 500);
		flights.get("C").put("D", 100);
		flights.get("E").put("F", 100);
		flights.get("F").put("C", 200);
		flights.get("D").put("G", 100);
		
		MinCostFlightsWithKConnections x = new MinCostFlightsWithKConnections();
		System.out.println(x.getPath("A", "D", 5, flights));
		
	}
}
