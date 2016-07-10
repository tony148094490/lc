package kc;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	// All distinct numbers
	// O( N + N -1 + N - 2...1 + 0)
	// This is by inserting numbers one by one
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0) return res;
        List<List<Integer>> newRes = new ArrayList<List<Integer>>();
        newRes.add(new ArrayList<Integer>());
        
        for(int i = 0 ; i < nums.length; i++){
        	res = newRes;
        	newRes = new ArrayList<List<Integer>>();
        	helper(nums, i, res, newRes);
        }
        return newRes;
    }
    
    private void helper(int[] nums, int i, List<List<Integer>> res, List<List<Integer>> newRes) {
    	for(List<Integer> cur:res) {
	    	for(int j = 0 ; j <= cur.size(); j++){
	    		cur.add(j, nums[i]);
	    		newRes.add(new ArrayList<Integer>(cur));
	    		cur.remove(j);
	    	}
    	}
    }
    
    //Recursion, fix the first character/number and permute the rest
    public List<List<Integer>> permute1(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length == 0) return res;
    	boolean[] visited = new boolean[nums.length];
    	dfs(nums, 0, new ArrayList<Integer>(), res, visited);
    	return res;
    }
    
    private void dfs(int[] nums, int depth, List<Integer> currentRes, List<List<Integer>> res, boolean[] visited) {
    	if(depth == nums.length){
    		res.add(new ArrayList<Integer>(currentRes));
    		return;
    	} 
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(visited[i]) continue;
    		
    		visited[i] = true;
    		currentRes.add(nums[i]);
    		dfs(nums, depth+1, currentRes, res, visited);
    		currentRes.remove(currentRes.size()-1);
    		visited[i] = false;
    	}
    }
    
    
    
    public static void main(String[] args) {
    	Permutations x = new Permutations();
    	int[] arr = {1,2,3};
    	System.out.println(x.permute1(arr));
    }
}
