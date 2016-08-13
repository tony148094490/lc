package kc;

public class BulbSwitcher {
    public int bulbSwitch(int n) {
    	return (int) Math.sqrt(n);
//        if(n<=0) return 0;
//        int[] dp = new int[n];
//        
//        for(int i = 1 ; i <= n; i++) {
//        	for(int j = 1 ; i * j <= n; j++) {
//        		dp[i * j - 1]++;
//        	}
//        }
//        int res = 0;
//        for(int i = 0 ; i < dp.length;i++) {
//        	if(dp[i] % 2 != 0) {
//        		res++;
//        	}
//        }
//        return res;
    }
}
