package kc;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
    	if(s.length() == 0 || t.length() == 0 || s.length() < t.length()) return 0;
    	int[][] dp = new int[t.length() + 1][s.length() + 1];
    	
    	for(int i = 0 ; i < dp[0].length; i++) {
    		dp[0][i] = 1;
    	}
    	
    	for(int i = 0 ;i < t.length(); i++) {
    		for(int j = i ; j < s.length(); j++) {
    			if(t.charAt(i) == s.charAt(j)) {
    				dp[i+1][j+1] = dp[i][j] + dp[i+1][j];
    			} else {
    				dp[i+1][j+1] = dp[i+1][j];
    			}
    		}
    	}
    	return dp[t.length()][s.length()];
    }
    
    public static void main(String[] args) {
		String a = "racbbbit";
		String b = "rabit";
		DistinctSubsequences x = new DistinctSubsequences();
		System.out.println(x.numDistinct(a, b));
	}
}
