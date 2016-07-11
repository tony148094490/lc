package kc;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};    
	    MaximumSubarray sol = new MaximumSubarray();
	    System.out.println(sol.maxSubArray(arr));
	}
	
    public int maxSubArray(int[] nums) {
    	if (nums.length == 0) return 0;
    	if (nums.length == 1) return nums[0];

    	int max = nums[0];
    	int currentSum = nums[0];
    	
    	for(int i = 1; i < nums.length; i++) {
    		if(nums[i] >= 0) {
    			if(currentSum >= 0) {
    				currentSum += nums[i];
    			} else {
    				currentSum = nums[i];
    			}
    		} else {
    			if(currentSum + nums[i] >= 0){
    				currentSum += nums[i];
    			} else {
    				currentSum = nums[i];
    			}
    		}    		
    		max = Math.max(max, currentSum);
    	}
    	
    	return max;
    }

}
