package airbnb;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.isEmpty() || t.isEmpty()) return "";
        int[] ref = new int[256];
        for(char c : t.toCharArray()) {
            ref[c]++;
        }
        int from = 0;
        int totalLen = t.length();
        int validLen = 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            ref[c]--;
            if(ref[c] >= 0) {
                validLen++;
                while(validLen == totalLen && from <= i) {
                    if(i - from + 1 < min) {
                        min = i - from + 1;
                        res = from;
                    }
                    char cur = s.charAt(from);
                    ref[cur]++;
                    if(ref[cur] > 0) {
                        validLen--;
                    }
                    from++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(res, res + min);
    }
    
    public static void main(String[] args) {
    	MinimumWindowSubstring x = new MinimumWindowSubstring();
    	String s = "ADOBECODEBANC";
    	String t = "ABC";
    	String ss = "caae";
    	String tt = "cae";
    	String sss = "abbbacab";
    	String ttt = "abc";
    	
    	String ssss = "abcabdebac";
    	String tttt = "cea";
    	
    	System.out.println(x.minWindow(s, t));
    	System.out.println(x.minWindow(ss, tt));
    	System.out.println(x.minWindow(sss, ttt));
    	System.out.println(x.minWindow(ssss, tttt));
	}
}
