package kc;
public class PaintHouseII {
    public int minCostII(int[][] costs) {
    	int m = costs.length;
    	if(m == 0) return 0;
    	int n = costs[0].length;
    	if(m > 1 && n < 2) return 0;
    	
    	if(m == 1 && n < 2) return costs[0][0];
    	
    	int[][] dp = new int[m+1][n];
    	int lowestIndex = -1;
    	int secondLowestIndex = -1;
    	for(int i = 0 ; i < m; i++) {
    		// get previous lowest and second lowest
    		lowestIndex = -1;
    		secondLowestIndex = -1;
    		for(int j = 0; j < n; j++) {
    			if(lowestIndex == -1) {
    				lowestIndex = j;
    			} else if(secondLowestIndex == -1) {
    				if(dp[i][lowestIndex] <= dp[i][j]) {
    					secondLowestIndex = j;
    				} else {
    					secondLowestIndex = lowestIndex;
    					lowestIndex = j;
    				}
    			} else {
    				if(dp[i][j] < dp[i][lowestIndex]) {
    					secondLowestIndex = lowestIndex;
    					lowestIndex = j;
    				} else if(dp[i][j] < dp[i][secondLowestIndex]) {
    					secondLowestIndex = j;
    				}
    			}
    		}
    		
    		for(int j = 0 ; j < n; j++) {
    			if(j == lowestIndex) {
    				dp[i+1][j] = dp[i][secondLowestIndex] + costs[i][j];
    			} else {
    				dp[i+1][j] = dp[i][lowestIndex] + costs[i][j];
    			}
    		}
    	}
    	
    	int res = Integer.MAX_VALUE;
    	for(int x : dp[m]) res = Math.min(res, x);
    	return res;
    }
    
    public static void main(String[] args) {
    	int[][] arr = new int[2][3];
    	arr[0][0] = 1;
    	arr[0][1] = 5;
    	arr[0][2] = 3;
    	arr[1][0] = 2;
    	arr[1][1] = 9;
    	arr[1][2] = 4;
    	PaintHouseII x = new PaintHouseII();
    	System.out.println(x.minCostII(arr));
    }
}
