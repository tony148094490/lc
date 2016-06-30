package kc;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

    	if(nums.length == 0) return 0;
        
    	Arrays.sort(nums);
    	int abs = Integer.MAX_VALUE;
    	int res = 0;
    	for(int i = 0 ; i < nums.length - 2 ; i++) {
    		if(i>0 && nums[i] == nums[i-1]) continue;
    		
    		int l = i + 1;
    		int r = nums.length - 1;
    		
    		while (l < r) {
    			int curSum = nums[i] + nums[l] + nums[r];
    			if(curSum == target) return target;
    			
    			if(Math.abs(target - curSum) < abs) {
    				abs = Math.abs(target - curSum);
    				res = curSum;
    			}
    			
    			if(target - curSum > 0) {
    				do {l++;} while(l<r && nums[l] == nums[l-1]);
    			}else {
    				do {r--;} while(l<r && nums[r] == nums[r+1]);
    			}
    			
    		}
    	}
    	return res;
     }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] S = {-1, 2, 1, -4};
		ThreeSumClosest three = new ThreeSumClosest();
		System.out.println(three.threeSumClosest(S, 1));
	}

}
