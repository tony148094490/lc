package kc;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 0 ; i < obstacleGrid.length ;i++) {
            for(int j = 0 ; j < n ; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[j+1] = 0;
                    continue;
                }
                dp[j+1] += dp[j];
            }
            dp[0] = 0;
        }
        return dp[n];

    }
    
    public static void main(String[] args) {
    	
    }
}
