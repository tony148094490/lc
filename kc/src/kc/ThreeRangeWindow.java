package kc;

public class ThreeRangeWindow {

	// 1,4,5,6,2,4
	// w = 2
	public int three(int[] arr, int k, int w) {
		int[][] dp = new int[k+1][arr.length];
		int[] ref = new int[arr.length];
		ref[0] = arr[0];
		int cur = arr[0];
		for(int i = 1 ; i < ref.length; i++) {
			if(i < w) {
				cur += arr[i];
				ref[i] = cur;
			} else {
				cur += arr[i] - arr[i-w];
				ref[i] = cur;
			}
		}
		
		// dp[k][i] = Math.max(dp[k][i-1], dp[k-1][i-w] + sumOf(i-w,i));
		for(int i = 1; i < dp.length; i++) {
			for(int j = 0 ; j < dp[0].length; j++) {
				if(j < w) {
					dp[i][j] = ref[j];
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-w] + ref[j]);
				}
			}
		}
		
		return dp[k][arr.length-1];
	}
}
