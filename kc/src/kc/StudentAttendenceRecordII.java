package kc;

public class StudentAttendenceRecordII {
    public int checkRecord(int n) {
        long mod = 1000000007;
        if(n == 1) return 3;
        if(n == 0) return 0;
        // ending with P 
        // ending with PL
        // ending with PLL
        // ending with LLL is not allowed
        // dp[i] denotes nr of possible combinations with len i
        // so with len of 3, we have dp[2] + dp[1] + dp[0] because we need to fix the letters on the rest of the positions
        //res[i] means that how many combo there is if we have i number to choose from
        long[] res = new long[n+1];
        res[0] = 1;
        res[1] = 2;
        res[2] = 4;
        
        int i = 3;
        while(i <= n) {
            res[i] = (res[i-1] + res[i-2] + res[i-3]) % mod;
            i++;
        }
        
        
        long check = 0;
        if(n == 2) {
            check = res[2];
        } else {
            check = res[i-1];
        }
        
        for(int j = 0; j < n;j++) {
            long s = (res[j] * res[n-j-1])%mod;
            check = (check + s)%mod;
        }
        
        return (int) check;
    }
}
