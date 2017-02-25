package kc;

// idea is to reduce the problem that 1 - n minmax is get min of Math.max((1-k), (k-n)) for each k.
// because when you come to k, you need to choose the higher half to guarantee a win
// while when iterating from 1 to n, we need to find the mininum such k + choise combo
public class GuessNumberHigherOrLower {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n+1];
        for(int i = 2; i <= n; i++) {
        	for(int j = i - 1; j >= 1; j--) {
        		dp[j][i] = Integer.MAX_VALUE;
        		for(int k = j; k <= i; k++) {
        			if(k == j) {
        				dp[j][i] = Math.min(dp[j][i], k + dp[k+1][i]);
        			} else if(k == i) {
        				dp[j][i] = Math.min(dp[j][i], k + dp[j][k-1]);
        			} else {
        				dp[j][i] = Math.min(dp[j][i], k + Math.max(dp[k+1][i], dp[j][k-1]));
        			}
        		}
        	}
        }
        return dp[1][n];
    }
    
    public static void main(String[] args) {
    	GuessNumberHigherOrLower x = new GuessNumberHigherOrLower();
    	System.out.println(x.getMoneyAmount(6));
	}

}
