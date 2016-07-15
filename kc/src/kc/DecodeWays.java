package kc;

public class DecodeWays {
    public int numDecodings(String s) {
    	
    	int[] dp = new int[s.length()+1];
    	if(s.length() == 0 || s.charAt(0) == '0') return 0;  	
    	int i = 1;
    	dp[0] = 1;
    	dp[1] = 1;
    	while(i < s.length()){
    		if((s.charAt(i-1) == '1' && s.charAt(i) != '0') || (s.charAt(i-1) == '2' && s.charAt(i) <= '6' && s.charAt(i) >'0')) {
    			dp[i+1] = dp[i] + dp[i-1];
    		} else if((s.charAt(i-1) == '1' && s.charAt(i) == '0') || s.charAt(i-1) == '2' && s.charAt(i) == '0') {
    			dp[i+1] = dp[i-1];
    		} else if(s.charAt(i) == '0') {
    			dp[i+1] = 0;
    		} else {
    			dp[i+1] = dp[i];
    		}
    		i++;
    	}
    	return dp[s.length()];
    }
    
    
    
    public static void main(String[] args) {
    	DecodeWays x = new DecodeWays();
    	System.out.println(x.numDecodings("12120"));
    	
    	
	}
}
