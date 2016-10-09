package kc;


public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
    	int r = dungeon.length;
    	int c = dungeon[0].length;
    	int[][] dp = new int[r][c];
    	dp[r-1][c-1] = Math.max(1 - dungeon[r-1][c-1], 1);
    	for(int i = r-2; i >= 0; i--) {
    		dp[i][c-1] = Math.max(dp[i+1][c-1] - dungeon[i][c-1], 1);
    	}
    	
    	for(int i = c-2; i >=0; i--) {
    		dp[r-1][i] = Math.max(dp[r-1][i+1] - dungeon[r-1][i], 1);
    	}
    	
    	for(int i = r-2; i >= 0 ; i--) {
    		for(int j = c-2; j>=0; j--) {
    			int right = Math.max(dp[i][j+1] - dungeon[i][j], 1);
    			int down = Math.max(dp[i+1][j] - dungeon[i][j], 1);
    			dp[i][j] = Math.min(right,down);
    		}
    	}
    	return dp[0][0];
    	
    }
    
    public static void main(String[] args) {
    	
    	
    	
    }
}
