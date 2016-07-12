package kc;

public class UniquePaths {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        int up = 0;
        int left = 0;
        for(int i = 0 ; i < m; i++ ){
        	for(int j = 0 ; j < n ; j++){
        		if(i == 0) {
        			up = 0;
        		} else {
        			up = dp[i-1][j];
        		}
        		
        		if(j == 0) {
        			left = 0;
        		} else {
        			left = dp[i][j-1];
        		}
        		
        		if(i == 0 && j == 0) {
        			dp[i][j] = 1;
        		} else {
        			dp[i][j] = up + left;
        		}
        	}
        }
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
    	UniquePaths x = new UniquePaths();
    	System.out.println(x.uniquePaths(4, 4));
    }
}
