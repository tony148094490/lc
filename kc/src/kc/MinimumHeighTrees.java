package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeighTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    	
    	for(int i = 0 ; i < edges.length; i++) {
    		if(map.containsKey(edges[i][0])){
    			map.get(edges[i][0]).add(edges[i][1]);
    		} else {
    			List<Integer> newEdge = new ArrayList<Integer>();
    			newEdge.add(edges[i][1]);
    			map.put(edges[i][0], newEdge);
    		}
    		
    		if(map.containsKey(edges[i][1])){
    			map.get(edges[i][1]).add(edges[i][0]);
    		} else {
    			List<Integer> newEdge = new ArrayList<Integer>();
    			newEdge.add(edges[i][0]);
    			map.put(edges[i][1], newEdge);
    		}
    	}
    	
    	List<Integer> leaves = new ArrayList<Integer>();
    	for(Integer x : map.keySet()) {
    		if(map.get(x).size() == 1) {
    			leaves.add(x);
    		}
    	}
    	
    	while(map.size() > 2) {
    		List<Integer> newLeaves = new ArrayList<Integer>();
    		for(Integer leaf : leaves) {
    			int neigh = map.get(leaf).get(0);
    			map.get(neigh).remove(leaf);
    			if(map.get(neigh).size() == 1) {
    				newLeaves.add(neigh);
    			}
    			map.remove(leaf);
    		}
    		leaves = newLeaves;
    	}
    	
    	List<Integer> res = new ArrayList<Integer>();
    	for(Integer i : map.keySet()) {
    		res.add(i);
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		int[][] arr = new int[3][2];
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 1;
		arr[1][1] = 2;
		arr[2][0] = 1;
		arr[2][1] = 3;
		MinimumHeighTrees x = new MinimumHeighTrees();
		System.out.println(x.findMinHeightTrees(4, arr));
		
	}
}
