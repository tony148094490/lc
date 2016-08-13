package kc;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
    	int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
        	for(int j = i - 1; j >= 0; j--) {
        		if(nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
        			dp[i] = dp[j] + 1;
        		}
        	}
        	res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    public int lengthOfLIS2(int[] nums) {
    	if(nums.length == 0) return 0;
    	int[] arr = new int[nums.length];
    	int curIndex = 0;
    	arr[0] = nums[0];
    	for(int i = 1; i < nums.length; i++) {
    		if(nums[i] > arr[curIndex]) {
    			curIndex++;
    			arr[curIndex] = nums[i];
    		} else {
    			int next = getNext(arr, nums[i], 0, curIndex);
    			arr[next] = nums[i];
    		}
    	}
    	return curIndex + 1;
    }
    
    private int getNext(int[] nums, int target, int l, int r) {
    	if(l == r) return l;
    	int m = (l + r) / 2;
    	if(nums[m] == target) return m;
    	if(nums[m] > target) {
    		if(m == 0 || nums[m-1] <= target) return m;
    		return getNext(nums, target, l , m - 1);
    	} else {
    		return getNext(nums, target, m+1, r);
    	}
    }
    
    
}
