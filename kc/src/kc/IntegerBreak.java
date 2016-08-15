package kc;

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < dp.length; i+=3) {
            dp[i] = dp[i-1] / 2 * 3;
            
            if(i+1 < dp.length)
            dp[i+1] = dp[i] / 2 * 3;
            
            if(i+2 < dp.length)
            dp[i+2] = dp[i + 1] / 3 * 4;
        }
        return dp[n-1];
    }
}
