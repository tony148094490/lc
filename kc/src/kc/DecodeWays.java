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
    
    public int numDecodings2(String s) {

		if(s == null || s.isEmpty()) return 0;
		long[] res = new long[2];
		res[0] = getSingle(s.charAt(0));
		if(s.length() < 2) return (int) res[0];
		res[1] = res[0] * getSingle(s.charAt(1)) + getDouble(s.charAt(0),s.charAt(1));
		for(int i = 2; i < s.length(); i++) {
			long temp = res[1];
			res[1] = (res[1] * getSingle(s.charAt(i)) + res[0] * getDouble(s.charAt(i-1), s.charAt(i))) % 1000000007;
			res[0] = temp;
		}
		return (int) res[1];
    }

	private int getSingle(char c) {
		if(c == '*') return 9;
		if(c == '0') return 0;
		return 1;
	}
	
	private int getDouble(char a, char b) {
		String combo = ""+ a + "" + b;
		if(a == '*' && b == '*') {
			return 15;
		} else if(a != '*' && b != '*') {
			if(Integer.parseInt(combo) >= 10 && Integer.parseInt(combo) <= 26) return 1;
			return 0;
		} else if(a == '*') {
			if(b >= '0' && b <= '6') {
				return 2;
			} else {
				return 1;
			}
		} else {
			if(a == '1') {
				return 9;
			} else if(a == '2') {
				return 6;
			} else {
				return 0;
			}
		}
	}
	    
    public static void main(String[] args) {
    	DecodeWays x = new DecodeWays();
    	System.out.println(x.numDecodings("12120"));
    	
    	
	}
}
