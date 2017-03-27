package kc;

public class EncodeStringWithShortestLength {
    public String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0 ; j + i < s.length(); j++) {
                String substr = s.substring(j, j + i + 1);
                if(substr.length() < 4) {
                    dp[j][j+i] = substr;
                } else {
                    dp[j][j+i] = substr;
                    for(int k = j; k < i+j; k++) {
                        if(dp[j][i+j].length() > (dp[j][k].length() + dp[k+1][i+j].length())) {
                            dp[j][i+j] = dp[j][k] + dp[k+1][i+j];
                        }
                    }
                    
                    for(int k = 0 ; k < substr.length(); k++) {
                        String potential = substr.substring(0, k+1);
                        if(substr.length() % potential.length() == 0 &&
                            substr.replaceAll(potential, "").length() == 0) {
                                String newPotential = substr.length()/potential.length() + "[" + dp[j][j+k] + "]";
                                if(newPotential.length() < dp[j][i+j].length()) {
                                    dp[j][i+j] = newPotential;
                                }
                            }
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
