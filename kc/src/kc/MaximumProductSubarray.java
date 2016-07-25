package kc;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
    	if(nums.length == 0) return -1;
    	int max = nums[0];
    	int curMax = nums[0];
    	int curMin = nums[0];
    	
    	for(int i = 1; i < nums.length ; i++){
    		if(nums[i] >= 0) {
    			curMax = Math.max(nums[i], nums[i] * curMax);
    			curMin = Math.min(nums[i], nums[i] * curMin);
    			max = Math.max(curMax, max);
    		} else {
    			int temp = curMax;
    			curMax = Math.max(nums[i], curMin * nums[i]);
    			curMin = Math.min(nums[i], temp * nums[i]);
    			max = Math.max(curMax, max);
    		}
    	}
    	return max;
    	
    }
    
    public static void main(String[] args) {
		int[] arr = {-4,-3,-2};
		MaximumProductSubarray x = new MaximumProductSubarray();
		System.out.println(x.maxProduct(arr));
	}
}
