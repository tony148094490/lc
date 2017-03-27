package kc;

public class TargetSum {
	//map array might be a little bit more clear
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) return 0;
        int sum = 0;
        for(int x : nums) sum += x;
        if(S > sum || S < -sum) return 0;
        int[][] dp = new int[nums.length+1][2 * sum + 1];
        dp[0][sum] = 1;//dummy zero; sum is actually the starting point with offset
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < 2 * sum + 1; j++) {
                if(j - nums[i] >= 0) {
                    dp[i+1][j] += dp[i][j-nums[i]];
                }
                
                if(j + nums[i] <= sum * 2) {
                    dp[i+1][j] += dp[i][j+nums[i]];
                }
            }
        }
        return dp[nums.length][S + sum];
    }
}
