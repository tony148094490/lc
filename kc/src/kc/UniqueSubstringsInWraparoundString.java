package kc;

public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        if(p.length() == 0) return 0;
        int[] dp = new int[26];
        dp[p.charAt(0) - 'a'] = 1;
        int runningMax = 1;
        for(int i = 1; i < p.length(); i++) {
            
            if(p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i) == 'a' && p.charAt(i-1) == 'z') {
                runningMax++;
                dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], runningMax);
            } else {
                runningMax = 1;
                dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], 1);
            }
            
        }
        int res = 0;
        for(int x : dp) res += x;
        return res;
    }
}
