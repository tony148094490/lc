package kc;

public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][] res = new int[m+1][n+1];
        
        for(String str : strs) {
            int oneNeeded = 0;
            int zeroNeeded = 0;
            for(char c : str.toCharArray()) {
                if(c == '1') {
                    oneNeeded++;
                } else {
                    zeroNeeded++;
                }
            }
            
            if(zeroNeeded > m || oneNeeded > n) continue;
           
            for(int zero = m; zero >= zeroNeeded; zero-- ) {
                for(int one = n; one >= oneNeeded; one--) {
                    res[zero][one] = Math.max(res[zero][one], res[zero-zeroNeeded][one-oneNeeded] + 1);
                }
            }
            
        }
           return res[m][n];
       }
}
