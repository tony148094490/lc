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
    
    public int findTargetSumWays2(int[] nums, int S) {
            if(nums.length == 0) return 0;
            int sum = nums[0];
            for(int i = 1; i < nums.length;i++) {
                sum += nums[i];
            }
            if(sum < S || -sum > S) return 0;
            
            int[][] dp = new int[sum * 2 + 1][nums.length + 1];
            
            dp[sum][0] = 1;
            
            for(int j = 1; j < dp[0].length; j++) {
                for(int i = 0; i < dp.length; i++) {
                    // use j's number as -
                    if(i + nums[j-1] < dp.length) {
                        dp[i][j] += dp[i+nums[j-1]][j-1];
                    }
                    
                    // use j's number as +
                    if(i - nums[j-1] >= 0) {
                        dp[i][j] += dp[i-nums[j-1]][j-1];
                    }
                    
                }
            }

            return dp[S + sum][nums.length];
    }
}
