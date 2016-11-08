package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {
    Set<Integer> overall = new HashSet<Integer>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length <= 0 || edges[0].length <= 0) return n == 1;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0 ; i < edges.length; i++) {
        	int left = edges[i][0];
        	int right = edges[i][1];
        	if(map.containsKey(left)) {
        		map.get(left).add(right);
        	} else {
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(right);
        		map.put(left, list);
        	}
        	
        	if(map.containsKey(right)) {
        		map.get(right).add(left);
        	} else {
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(left);
        		map.put(right, list);
        	}
        }
        
        if (dfs(map, null, edges[0][0], new HashSet<Integer>()) && overall.size() == n) {
        	return true;
        }
        return false;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> map, Integer previous, int next, Set<Integer> visited) {
    	
    	if(visited.contains(next)) return false;
		visited.add(next);
		boolean result = true;
    	for(int i = 0 ; i < map.get(next).size(); i++) {
    		if(previous != null && map.get(next).get(i) == previous.intValue()) {
    			continue;
    		} else {    	
    			result &= dfs(map, next, map.get(next).get(i), visited);
    			if(result == false) return false;
    		}
    	}
    	visited.remove(next);
    	overall.add(next);
    	return true;
    }
    
    public static void main(String[] args) {
    	int[][] edges = new int[3][2];
    	edges[0][0] = 0;
    	edges[0][1] = 1;
    	edges[1][0] = 2;
    	edges[1][1] = 3;
    	edges[2][0] = 1;
    	edges[2][1] = 2;
//    	edges[3][0] = 1;
//    	edges[3][1] = 4;
//    	edges[4][0] = 2;
//    	edges[4][1] = 4;
    	
    	GraphValidTree x = new GraphValidTree();
    	System.out.println(x.validTree(4, edges));
    	
    }
}
