package kc;

public class PaintHouse {
    public int minCost(int[][] costs) {
    	if(costs.length <= 1) return 0;
        int[][] dp = new int[costs.length+1][costs[0].length];
        for(int i = 0 ; i < costs.length; i++) {
        	dp[i+1][0] = Math.min(dp[i][1], dp[i][2]) + costs[i][0];
        	dp[i+1][1] = Math.min(dp[i][0], dp[i][2]) + costs[i][1];
        	dp[i+1][2] = Math.min(dp[i][1], dp[i][0]) + costs[i][2];
        }
        return Math.min(Math.min(dp[costs.length][0], dp[costs.length][1]), dp[costs.length][2]);
    }
}
