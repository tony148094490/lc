package airbnb;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if(s.isEmpty() || t.isEmpty()) return "";
		int[] ref = new int[256];
		for(char c : t.toCharArray()) ref[c]++;
		int from = 0;
		int res = 0;
		int min = Integer.MAX_VALUE;
		int counter = t.length();
		for(int i = 0 ; i < s.length(); i++) {
			char c = s.charAt(i);
			ref[c]--;
			if(ref[c] >= 0) counter--;
			while(counter == 0) {
				if(i - from + 1 < min) {
					min = i - from + 1;
					res = from;
				}

				ref[s.charAt(from)]++;
				if(ref[s.charAt(from)] > 0) counter++;
				
				from++;

			}
		}

		if(min == Integer.MAX_VALUE) return "";
		return s.substring(res, res + min);
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
