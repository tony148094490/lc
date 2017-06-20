package kc;

public class KSum {
	public int kSum(int[] arr, int k, int target) {
		int[][][] dp = new int[arr.length+1][k+1][target+1];
		for(int i = 0 ; i < dp.length; i++) {
			for(int j = 0 ; j < dp[0].length;j++) {
				for(int m = 0; m < dp[0][0].length;m++) {
					if(j==0&&m==0) {
						dp[i][j][m] = 1;
					} else if(i!=0&&j!=0&&m!=0) {
						dp[i][j][m] = dp[i-1][j][m];
						if(m-arr[i-1]>=0) {
							dp[i][j][m] += dp[i-1][j-1][m-arr[i-1]];
						}
					}
				}
			}
		}
		return dp[arr.length][k][target];
	}
}
