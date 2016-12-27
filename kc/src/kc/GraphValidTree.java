package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0) return n == 1;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0 ; i < edges.length; i++) {
            if(!map.containsKey(edges[i][0])) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(edges[i][1]);
                map.put(edges[i][0], list);
            } else {
                map.get(edges[i][0]).add(edges[i][1]);
            }
            
            if(!map.containsKey(edges[i][1])) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(edges[i][0]);
                map.put(edges[i][1], list);
            } else {
                map.get(edges[i][1]).add(edges[i][0]);
            }
        }
        
        Set<Integer> nodes = new HashSet<Integer>();
        

        if(!dfs(map, new HashSet<Integer>(), edges[0][0], null, nodes)) return false;
        

        if(nodes.size() != n) return false;
        
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int cur, Integer parent, Set<Integer> overall) {
        
        if(!map.containsKey(cur)){
          overall.add(cur);
          return true;  
        }
        
        if(visited.contains(cur)) return false;
        visited.add(cur);
        List<Integer> list = map.get(cur);
        for(Integer x : list) {
            if(parent != null && parent.intValue() == x) continue;
            if(!dfs(map, visited, x, cur, overall)) return false;
        }
        visited.remove(cur);
        overall.add(cur);
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
