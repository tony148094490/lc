package kc;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum % 2 == 1) return false;
        sum /= 2;
        
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        
        dp[0][0] = true;
        for(int i = 1; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        
        for(int i = 1; i <= nums.length ;i++) {
            for(int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i-1]) {
                    dp[i][j] |= dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
