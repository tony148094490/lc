package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 0) return 0;
    	Arrays.sort(nums);
        if(nums[0] > target) return 0;
        List<Integer> res = new ArrayList<Integer>();
        helper(nums, target, new ArrayList<Integer>(), res);
        return res.size();
    }
    private void helper(int[] nums, int target, List<Integer> curRes, List<Integer> res) {
    	if(target < 0) return;
    	if(target == 0) {
    		res.add(1);
    		return;
    	}
    	for(int i = 0; i < nums.length && nums[i] <= target; i++) {
    		curRes.add(nums[i]);
    		helper(nums, target- nums[i], curRes, res);
    		curRes.remove(curRes.size()-1);
    	}
    }
    
    public int combinationSum4T(int[] nums, int target) {
        if(nums.length == 0) return 0;
    	Arrays.sort(nums);
        if(nums[0] > target) return 0;
        int[] sum = new int[target];
        for(int i = nums[0]; i <= target; i++) {
        	for(int j = 0 ; j < nums.length && nums[j] <= i; j++) {
        		if(nums[j] == i) {
    				sum[i-1] += 1;
    				break;
    			}
        		int temp = i - nums[j];
            	sum[i-1] += sum[temp-1];
        		}
        	}
       return sum[target-1]; 
    }
    
    public static void main(String[] args) {
    	CombinationSum4 x = new CombinationSum4();
    	int[] arr = {2,3,4};
    	System.out.println(x.combinationSum4(arr, 10));
    	System.out.println(x.combinationSum4T(arr, 10));
    	
	}
}
