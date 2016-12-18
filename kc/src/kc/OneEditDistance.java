package kc;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() == 0) return t.length() == 1;
        if(t.length() == 0) return s.length() == 1;
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 0; i < t.length(); i++) {
            dp[0][i+1] = i+1;
        }
        for(int j = 0 ; j < s.length(); j++) {
            dp[j+1][0] = j + 1;
        }
        for(int i = 0 ; i < s.length(); i++) {
            for(int j = 0 ; j < t.length(); j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]) + 1;
                }
            }
        }
        return dp[s.length()][t.length()] == 1;
    }
    
    public boolean isOneEditDistance2(String s, String t) {
        for(int i = 0 ; i < Math.min(s.length(), t.length()); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(s.length() == t.length()) {
                    return s.substring(i+1).equals(t.substring(i+1));
                } else if(s.length() > t.length()) {
                    return s.substring(i+1).equals(t.substring(i));
                } else {
                    return t.substring(i+1).equals(s.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
    
    public boolean isOneEditDistance3(String s, String t) {
        if(Math.abs(s.length() - t.length()) >= 2) return false;
        if(s.length() == 0 && t.length() == 0) return false;
        if(s.equals(t)) return false;
        for(int i = 0 ; i < Math.min(s.length(), t.length()); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(s.length() == t.length()) {
                    return s.substring(i+1).equals(t.substring(i+1));
                } else if(s.length() > t.length()) {
                    return s.substring(i+1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	String s = "abcdefg";
    	String t = "abcddefg";
    	OneEditDistance x = new OneEditDistance();
    	System.out.println(x.isOneEditDistance(s, t));
    }
}
