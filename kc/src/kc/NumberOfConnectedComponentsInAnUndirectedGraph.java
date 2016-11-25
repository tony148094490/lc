package kc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  Given n nodes labeled from 0 to n - 1 and a list of undirected
 *   edges (each edge is a pair of nodes), 
 *   write a function to find the number of connected components in an undirected graph.

Example 1:

     0          3
     |          |
     1 --- 2    4

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:

     0           4
     |           |
     1 --- 2 --- 3

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges. 
 *
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
     //construct an adjacency list first:
    	Map<Integer, Set<Integer>> aList = new HashMap<Integer, Set<Integer>>();
    	for(int i = 0 ; i<edges.length; i++) {
    		if(aList.containsKey(edges[i][0])) {
    			aList.get(edges[i][0]).add(edges[i][1]);
    		} else {
    			Set<Integer> set = new HashSet<Integer>();
    			set.add(edges[i][1]);
    			aList.put(edges[i][0], set);
    		}
    		
    		if(aList.containsKey(edges[i][1])) {
    			aList.get(edges[i][1]).add(edges[i][0]);
    		} else {
    			Set<Integer> set = new HashSet<Integer>();
    			set.add(edges[i][0]);
    			aList.put(edges[i][1], set);
    		}
    	}
    	int res = 0;
    	Set<Integer> visited = new HashSet<Integer>();
    	for(int i = 0 ; i < n; i++) {
    		if(visited.contains(i)) continue;
    		res++;
    		visited.add(i);
    		dfs(aList, visited, i);
    	}
    	
    	return res;
    }
    
    private void dfs(Map<Integer, Set<Integer>> map, Set<Integer> visited, int cur) {
    	if(!map.containsKey(cur)) return;
    	Set<Integer> neighbors = map.get(cur);
    	for(Integer x : neighbors) {
    		if(visited.contains(x) || !map.containsKey(x)) continue;
    		visited.add(x);
    		dfs(map,visited, x);
    	}
    }
    
    public static void main(String[] args) {
    	NumberOfConnectedComponentsInAnUndirectedGraph x = new NumberOfConnectedComponentsInAnUndirectedGraph();
    	int[][] arr = new int[4][2];
    	arr[0][0] = 0;
    	arr[0][1] = 1;
    	arr[1][0] = 1;
    	arr[1][1] = 2;
    	arr[2][0] = 2;
    	arr[2][1] = 3;
    	arr[3][0] = 3;
    	arr[3][1] = 4;
    	
    	System.out.println(x.countComponents(6, arr));
    	
    }
}






