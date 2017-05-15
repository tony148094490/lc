package kc;

import java.util.Comparator;

public class EncodeStringWithShortestLength {
    public String encode(String s) {
        if(s.length() < 4) return s;
        String[][] dp = new String[s.length()][s.length()];
        for(int i = 0 ; i < s.length(); i++) {
            for(int j = i ; j >= 0; j--) {
                String str = s.substring(j, i+1);
                if(str.length() < 4) {
                    dp[j][i] = str;
                } else {
                    dp[j][i] = str;
                    //shorten with the help of substring, no encoding on current level yet.
                    for(int k = j; k < i;k++) {
                        if(dp[j][k].length() + dp[k+1][i].length() < dp[j][i].length()) {
                            dp[j][i] = dp[j][k] + dp[k+1][i];
                        }
                    }
                    
                    //encode/shorten itself if possible
                    for(int k = 0 ; k < str.length() ; k++) {
                        String potential = str.substring(0, k+1);
                        if(str.length() % potential.length() == 0 && str.replaceAll(potential,"").length() == 0) {
                            String realPotential = str.length()/potential.length() + "[" + dp[j][j+k] + "]";
                            if(realPotential.length() < dp[j][i].length()) {
                                dp[j][i] = realPotential;
                            }
                        }
                    }

                }
            }
        }
        Comparator<String> comp = (a,b) -> {return a.length() - b.length();};

        
        return dp[0][s.length()-1];
    }
}
