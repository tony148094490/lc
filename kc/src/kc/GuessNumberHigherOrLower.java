package kc;

// idea is to reduce the problem that 1 - n minmax is get min of Math.max((1-k), (k-n)) for each k.
// because when you come to k, you need to choose the higher half to guarantee a win
// while when iterating from 1 to n, we need to find the mininum such k + choise combo
public class GuessNumberHigherOrLower {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n+1];

        for(int end = 2; end <= n; end++) {
        	for(int start = end-1; start >= 1; start--) {
        		dp[start][end] = Integer.MAX_VALUE;
        		for(int k = start; k <= end; k++) {
        			if(k == start) {
        				dp[start][end] = Math.min(dp[start][end], k + dp[k+1][end]);
        			} else if(k == end) {
        				dp[start][end] = Math.min(dp[start][end], k + dp[start][k-1]);
        			} else {
        				dp[start][end] = Math.min(dp[start][end], k + Math.max(dp[k+1][end], dp[start][k-1]));
        			}
        		}
        	}
        }
        
        
        return dp[1][n];
    }
    
    public static void main(String[] args) {
    	GuessNumberHigherOrLower x = new GuessNumberHigherOrLower();
    	System.out.println(x.getMoneyAmount(34));
	}

}
