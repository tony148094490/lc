package kc;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
    	if(s.length() <= 1) return s;
        int res = getPivotPoint(s);
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i > res; i--) {
        	sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }
    
    private int getPivotPoint(String s) {
    	for(int i = s.length() - 1; i >= 1; i--) {
    		if(isPalin(s, 0, i)) {
    			return i;
    		}
    	}
    	return 0;
    }
    
    private boolean isPalin(String s, int i, int j) {
    	while( i < j) {
    		if(s.charAt(i) != s.charAt(j)) return false;
    		i++;
    		j--;
    	}
    	return true;
    }
    
    // key is to find the longest suffix that's also a prefix since they are in reverse positions
    //, it means they both are palindromes
    // it did not use kmp to search for a string within a string (or needle in a haystack, which is what kmp 
    // intends to solve. However, the prefix suffix array that's required in the kmp pre-processing is 
    // used to identify the reversed prefix is also the match of an actual prefix starting from the beginning.
    
    public String shortestPalindrome2(String s) {
        if(s.length() == 0) return "";
        if(s.length() == 1) return s;
        StringBuilder sb = new StringBuilder(s);
        String res = sb.toString() + " " + sb.reverse().toString();
        int[] kmp = new int[res.length()];
        kmp = lps(res);
        int len = kmp[kmp.length-1];
        StringBuilder newSb = new StringBuilder(s);
        return newSb.reverse().substring(0, s.length() - len) + s;
    }
    
    private int[] lps(String str) {
    int[] res = new int[str.length()];
    int first = 0;
    int second = 1;
    while(second < str.length()) {
        if(str.charAt(first) == str.charAt(second)) {
            res[second] = first + 1;
            first++;
        } else {
            if(first == 0) {
                second++;
            }
            
            while(first > 0 && str.charAt(first) != str.charAt(second)) {
            	// when backing off, we need to back off to the first appearance of the pattern
            	// instead of the last one
                first = res[first-1] ; 
            }
            
            if(str.charAt(first) == str.charAt(second)) {
                res[second] = first+1;
                first++;
            }
        }

        second++;
    }
    return res;
}
    
    
    public static void main(String[] args) {
    	ShortestPalindrome x = new ShortestPalindrome();
    	String str = "ababb";
    	System.out.println(x.shortestPalindrome2(str));
    	
    }
}
