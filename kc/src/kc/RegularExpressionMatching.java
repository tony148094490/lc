package kc;

/**
 * '.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 *
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
    	boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    	dp[0][0] = true;
    	for(int i = 0; i < p.length(); i++){
    		if(i > 0 && p.charAt(i) == '*') {
    			dp[0][i+1] = dp[0][i-1];
    		}
    	}
    	for(int i = 0; i < s.length(); i++) {
    		for(int j = 0; j < p.length() ;j++){
    			if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
    				dp[i + 1][j + 1] = dp[i][j];
    			}
    			
    			if(p.charAt(j) == '*') {
    				if(s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') {
        				dp[i+1][j+1] = (dp[i+1][j] || dp[i+1][j-1] || dp[i][j+1]);
    				} else {
    					dp[i+1][j+1] = dp[i+1][j-1];
    				}
    			}
    		}
    	}
    	return dp[s.length()][p.length()];
    }
    
    public boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 0 ; i < p.length(); i++) {
            if(i > 0 && p.charAt(i) == '*') {
                dp[0][i+1] = dp[0][i-1];
            }
        }
        
        for(int i = 0 ; i < s.length(); i++) {
            for(int j = 0 ; j < p.length(); j++) {
                if(p.charAt(j) == '*') {
                    if(j > 0 && dp[i+1][j-1]) {
                        dp[i+1][j+1] = true;
                    } else if(dp[i+1][j] == true) {
                        dp[i+1][j+1] = true;
                    } else if(((i > 0 && s.charAt(i) == p.charAt(j-1) ) || (j> 0 && p.charAt(j-1) == '.')) && dp[i][j+1] == true) {
                        dp[i+1][j+1] = true;// this part is extension, meaning the p.charAt(j-1) needs to match p.charAt(i)
                    }
                } else if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
    
    public boolean isMatch3(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i < p.length(); i++) {
            if(p.charAt(i) == '*') {
                dp[0][i+1] = dp[0][i-1];
            }
        }
        for(int i = 0 ; i < s.length(); i++) {
            for(int j = 0 ; j < p.length() ; j++) {
                if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                } else if(p.charAt(j) == '*') {
                    dp[i+1][j+1] |= dp[i+1][j-1];
                    dp[i+1][j+1] |= dp[i+1][j];
                    if(i > 0 && j > 0 && (p.charAt(j-1) == s.charAt(i-1) && s.charAt(i) == s.charAt(i-1)|| p.charAt(j-1) == '.')) {
                       dp[i+1][j+1] |= dp[i][j+1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    
    
    public static void main(String[] args) {
    	RegularExpressionMatching x = new RegularExpressionMatching();
    	System.out.println(x.isMatch("aa","a") + "," + x.isMatch3("aa","a"));
    	System.out.println(x.isMatch("aa","aa") + "," + x.isMatch3("aa","aa"));
    	System.out.println(x.isMatch("aaa","aa") + "," + x.isMatch3("aaa","aa"));
    	System.out.println(x.isMatch("aa", "a*") + "," + x.isMatch3("aa", "a*"));
    	System.out.println(x.isMatch("aa", ".*") + "," + x.isMatch3("aa", ".*"));
    	System.out.println(x.isMatch("ab", ".*") + "," + x.isMatch3("ab", ".*"));
    	System.out.println(x.isMatch("aab", "c*a*b") + "," + x.isMatch3("aab", "c*a*b"));
    	System.out.println(x.isMatch("acaabbaccbbacaabbbb", "a*.*b*.*a*aa*a*") + "," + x.isMatch3("acaabbaccbbacaabbbb", "a*.*b*.*a*aa*a*"));
    	System.out.println(x.isMatch("a", "ab*a") + "," + x.isMatch3("a", "ab*a"));
    	System.out.println(x.isMatch("ab", ".*c") + "," + x.isMatch3("ab", ".*c"));
    	System.out.println(x.isMatch("bbbba", ".*a*a") + "," + x.isMatch3("bbbba", ".*a*a"));

    	
	}
}
