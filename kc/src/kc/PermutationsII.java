package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    //Recursion, fix the first character/number and permute the rest
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length == 0) return res;
    	boolean[] visited = new boolean[nums.length];
    	Arrays.sort(nums);
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
    		
    		if(i>0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
    		
    		visited[i] = true;
    		currentRes.add(nums[i]);
    		dfs(nums, depth+1, currentRes, res, visited);
    		currentRes.remove(currentRes.size()-1);
    		visited[i] = false;
    	}
    }
    
    
    private boolean isSame(List<Integer> a, List<Integer> b) {
    	for(int i = 0 ; i < a.size();i++) {
    		if(a.get(i) == b.get(i)){
    			continue;
    		} else{
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	PermutationsII x = new PermutationsII();
    	int[] arr = {-1,-1,0,1,1,2};
    	List<List<Integer>> res = x.permuteUnique(arr);
    	System.out.println(res.size());
    	Set<List<Integer>> set = new HashSet<List<Integer>>();
    	for(List<Integer> list: res) {
    		for(List<Integer> inside : set) {
    			if(x.isSame(list, inside)) {
    				System.out.println("Found dup!" + list);
    			}
    		}
    		set.add(list);
    	}
    	
    	System.out.println();
    	
    	String res1 = "";
    }
}
