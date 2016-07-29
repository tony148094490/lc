package kc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0 ; i < prerequisites.length; i++) {
        	if(map.containsKey(prerequisites[i][1])) {
        		List<Integer> list = map.get(prerequisites[i][1]);
        		list.add(prerequisites[i][0]);
        	} else {
        		List<Integer> list = new LinkedList<Integer>();
        		list.add(prerequisites[i][0]);
        		map.put(prerequisites[i][1],list);
        	}
        }

        Set<Integer> visited = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        for(Entry<Integer, List<Integer>> entry : map.entrySet()) {
 	
        	List<Integer> res = entry.getValue();
        	for(Integer x : res) {
        		if(visited.contains(x)) {
        			continue;
        		}
        		if(!dfs(map,x,new HashSet<Integer>(), visited, stack)) return new int[0];

        	}
        	
        	int x = entry.getKey();
    		if(!visited.contains(x)){
    			visited.add(x);
    			stack.push(x);
    		}
        }
                    
        int[] res = new int[numCourses];
        int i = 0;
        
        while(!stack.isEmpty()) {
        	res[i] = stack.pop();
        	i++;
        }
        
        for(int j = 0 ; j < numCourses ;j++) {
        	if(!visited.contains(j)) {
        		res[i] = j;
        		i++;
        	}
        }  
        return res;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> map, int start, Set<Integer> visited, Set<Integer> overallVisited, Stack<Integer> stack) {
    	if(!map.containsKey(start)) {
    	    if(!overallVisited.contains(start)){
    	    	overallVisited.add(start);
    	    	stack.push(start);
    	    }
    		return true;
    	}
    	if(visited.contains(start)) 
    	{   
    	    return false;
    	}
    	    
    	visited.add(start);
    	
    	for(Integer x : map.get(start)) {
    		if(!dfs(map,x,visited, overallVisited, stack)) return false;
    	}
    	
    	if(!overallVisited.contains(start)){
    		overallVisited.add(start);
    		stack.push(start);
    	}
    	visited.remove(start);
    	return true;
    }
    
    
    public static void main(String[] args) {
		CourseScheduleII x = new CourseScheduleII();
		int[][] arr = new int[2][2];
		arr[0][0] = 1;
		arr[0][1] = 0;

		arr[1][0] = 2;
		arr[1][1] = 1;
		
		int[] res = x.findOrder(3, arr);
		for(Integer xx : res) {
			System.out.println(xx);
		}
	}
}
