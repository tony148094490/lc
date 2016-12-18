package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if(numCourses == 0) return res;
        Stack<Integer> stack = new Stack<Integer>();
        Set<Integer> overall = new HashSet<Integer>();
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        for(int[] preq : prerequisites) {
            if(adj.containsKey(preq[1])) {
                adj.get(preq[1]).add(preq[0]);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(preq[0]);
                adj.put(preq[1], list);
            }
        }
        
        for(Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            if(overall.contains(entry.getKey())) continue;
            if(!dfs(adj, entry.getKey(), new HashSet<Integer>(), overall, stack)) return new int[0];
        }
        
        int i = 0;
        while(!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        for(int j = 0 ; j < numCourses ; j++) {
            if(!overall.contains(j)) {
                res[i] = j;
                i++;
            }
        }
       return res;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> map, int cur, Set<Integer> visited, Set<Integer> overall, Stack<Integer> res) {
        if(!map.containsKey(cur)) {
            if(!overall.contains(cur)) {
                overall.add(cur);
                res.push(cur);
            }
            return true;
        }
        
        if(visited.contains(cur)) return false;
        
        List<Integer> nexts = map.get(cur);
        
        visited.add(cur);
        for(Integer x : nexts) {
            if(!dfs(map, x, visited, overall, res)) return false;
        }
        
        if(!overall.contains(cur)) {
            overall.add(cur);
            res.push(cur);
        }
        visited.remove(cur);
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
