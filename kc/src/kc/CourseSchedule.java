package kc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class CourseSchedule {
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0 ; i < prerequisites.length; i++) {
        	if(map.containsKey(prerequisites[i][0])) {
        		List<Integer> list = map.get(prerequisites[i][0]);
        		list.add(prerequisites[i][1]);
        	} else {
        		List<Integer> list = new LinkedList<Integer>();
        		list.add(prerequisites[i][1]);
        		map.put(prerequisites[i][0],list);
        	}
        }

        Set<Integer> visited = new HashSet<Integer>();
        
        for(Entry<Integer, List<Integer>> entry : map.entrySet()) {
        	List<Integer> res = entry.getValue();
        	for(Integer x : res) {
        		if(visited.contains(x)) {
        			continue;
        		}
        		if(!dfs(map,x,new HashSet<Integer>(), visited)) return false;
        		visited.add(x);
        	}
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> map, int start, Set<Integer> visited, Set<Integer> overallVisited) {
    	if(!map.containsKey(start)) {
    	    overallVisited.add(start);
    		return true;
    	}
    	if(visited.contains(start)) 
    	{   
    	    return false;
    	}
    	    
    	visited.add(start);
    	for(Integer x : map.get(start)) {
    		if(!dfs(map,x,visited, overallVisited)) return false;
    	}
    	overallVisited.add(start);
    	visited.remove(start);
    	return true;
    }
    

}
