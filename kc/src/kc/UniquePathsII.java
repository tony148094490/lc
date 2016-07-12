package kc;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int row = obstacleGrid.length;
    	int col = obstacleGrid[0].length;
    	
    	int[][] dp = new int[row+1][col+1];
    	dp[0][1] = 1;
    	for(int i = 1 ; i < dp.length; i++){
    		for(int j = 1 ; j <dp[0].length; j++) {
    			if(obstacleGrid[i-1][j-1] == 1) {
    				dp[i][j] = 0;
    			} else {
    				dp[i][j] = dp[i-1][j] + dp[i][j-1];
    			}
    		}
    	}
        return dp[row][col];

    }
    
    public static void main(String[] args) {
    	
    }
}
