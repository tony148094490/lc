package kc;

public class PerfectSquare {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n ;i++) {
            dp[i] = i;
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j*j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
    	PerfectSquare x = new PerfectSquare();
    	System.out.println(x.numSquares(9));
	}
}
