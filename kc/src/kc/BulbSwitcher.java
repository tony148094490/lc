package kc;

public class BulbSwitcher {
	/**
	 * 
	 * We can come to the conclusion that the bulb i is toggled k times.

Here, k is the number of i's factors (except 1).

k + 1 will be the total number of i's factors

For example:

    Factors of 6: 1, 2, 3, 6 (3 factors except 1, so it will be toggled 3 times)
    Factors of 7: 1, 7 (1 factors except 1, so it will be toggled once)
    ....

Now, the key problem here is to judge whether k is even or odd.

Since all bulbs are on at the beginning, we can get:

    If k is odd, the bulb will be off in the end.(after odd times of toggling).
    If k is even, the bulb i will be on in the end (after even times of toggling).

As we all know, a natural number can divided by 1 and itself, and all factors appear in pairs.

When we know that p is i's factor, we are sure q = i/p is also i's factor.

If i has no factor p that makes p = i/p, k+ 1 is even.

If i has a factor p that makes p = i/p (i = p^2, i is a perfect square of p), k+ 1 is odd.

So we get that in the end:

    If i is a perfect square , k+ 1 is odd, k is even (bulb i is on).
    If i is NOT a perfect square , k+ 1 is even, k is odd (bulb i is off).

We want to find how many bulbs are on after n rounds (In the end).

That means we need to find out how many perfect square numbers are NO MORE than n.

The number of perfect square numbers which are no more than n, is the square root of the maximum perfect square number which is NO MORE than
	 * @param n
	 * @return
	 */
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
