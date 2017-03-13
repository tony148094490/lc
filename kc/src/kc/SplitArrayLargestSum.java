package kc;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
    	if(nums.length == 0) return 0;
    	
    	long low = nums[0];
    	long high = 0;
    	for(int x : nums) {
    		low = Math.max(low, x);
    		high += x;
    	}
    	
    	if(m == nums.length) return (int) low;
    	
    	while(low <= high) {
    		long target = low + (high - low) / 2;
    		if(isValid(nums, target, m)) {
    			high = target - 1;
    		} else {
    			low = target + 1;
    		}
    	}
    	return (int) low;
    }
    
    private boolean isValid(int[] nums, long target, int splits) {
    	int split = 1;
    	long runningSum = 0;
    	for(int x : nums) {
    		runningSum += x;
    		if(runningSum > target) {
    			runningSum = x;
    			split++;
    			if(split > splits) return false;
    		}
    	}
    	return true;
    }
}
