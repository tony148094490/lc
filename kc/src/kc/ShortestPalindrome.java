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
    
    
    public String shortestPalindrome2(String s) {
        if(s.length() == 0) return "";
        if(s.length() == 1) return s;
        StringBuilder sb = new StringBuilder(s);
        String res = sb.toString() + " " + sb.reverse().toString();
        int[] kmp = new int[res.length()];
        int i = 0;
        int j = 1;
        while(j < res.length()) {
            if(res.charAt(j) == res.charAt(i)) {
                kmp[j] = i + 1;
                j++;
                i++;
            } else {
                if(i == 0) {
                    kmp[j] = 0;
                    j++;
                    continue;
                }
                
                while(i > 0) {
                    i = kmp[i-1];
                    if(res.charAt(j) == res.charAt(i)) {
                        kmp[j] = i + 1;
                        j++;
                        i++;
                        break;
                    }
                    
                    if (i == 0) {
                        kmp[j] = 0;
                        j++;
                        break;
                    }            
                }
            }
            
        }
        int len = kmp[kmp.length-1];
        StringBuilder newSb = new StringBuilder(s);
        return newSb.reverse().substring(0, s.length() - len) + s;
    }
    
    
    public static void main(String[] args) {
    	ShortestPalindrome x = new ShortestPalindrome();
    	System.out.println(x.shortestPalindrome2("abcd"));
    	
    }
}
