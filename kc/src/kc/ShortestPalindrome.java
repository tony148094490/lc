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
    
    
    
    public static void main(String[] args) {
    	ShortestPalindrome x = new ShortestPalindrome();
    	System.out.println(x.shortestPalindrome("ababbbabbaba"));
    	System.out.println("ababbabbbababbbabbaba");
    }
}
