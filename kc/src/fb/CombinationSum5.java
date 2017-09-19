package fb;

import java.util.Arrays;

public class CombinationSum5 {
	public int get(int[] arr, int target) {
		int[] dp = new int[target+1];
		dp[0] = 1;
		Arrays.sort(arr);
		for(int i = 1; i <= target; i++) {
			for(int x : arr) {
				if(x <= i) {
					dp[i] += dp[i-x];
				} else {
					break;
				}
			}
		}
		return dp[target];
	}
}
