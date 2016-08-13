package kc;


public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 1 ; i <= amount; i++) {
            dp[i] = amount + 1;
            for(Integer x : coins) {
                if(x > i) continue;
                int remainder = i - x;
                dp[i] = Math.min(dp[remainder] + 1, dp[i]);
            }
        }
        if(dp[amount] == amount + 1) return -1;
        return dp[amount];
    }
    
    public static void main(String[] args) {
    	CoinChange a = new CoinChange();
    	int[] arr = {1, 2, 5};
    	System.out.println(a.coinChange(arr, 100));
	}
}
