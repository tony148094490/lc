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
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int cur = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > tails[cur]) {
                cur++;
                tails[cur] = nums[i];
            } else {
                int len = getLen(tails, 0, cur, nums[i]);
                tails[len] = nums[i];
            }
        }
        return cur+1;
    }
    
    private int getLen(int[] tails, int l, int r, int target) {
        if(l == r) return l;
        if(l + 1 == r) {
            if(tails[l] >= target) return l;
            return r;
        }
        int m = (l + r) / 2;
        if(tails[m] == target) return m;
        if(tails[m] > target) {	
            return getLen(tails, l, m, target);
        } else {
            return getLen(tails, m+1, r, target);
        }
    }
    
}
