package fb;

public class CommonSubstrWithLenghK {
	
	// honestly, no point of using dp...
	public boolean hasCommonK(String A, String B, int k) {
		int[][] dp = new int[A.length()+1][B.length()+1];
		for(int i = 0 ; i < A.length(); i++) {
			for(int j = 0 ; j < B.length(); j++) {
				if(A.charAt(i) == B.charAt(j)) {
					dp[i+1][j+1] = dp[i][j] + 1;
					if(dp[i+1][j+1] == k) return true;
				}
			}
		}
		return false;
	}
}
