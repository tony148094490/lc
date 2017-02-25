package kc;

public class SuperPow {
    private final int k = 1337;
    // the idea is that ab% k = a%k * b %k % k.
    public int superPow(int a, int[] b) {
        int res = 1;
        if(a == k) return 0;
        for(int i = 0 ; i < b.length; i++) {
            res = modPow(res, 10) * modPow(a, b[i]) % k;
        }
        return res;
    }
    
    private int modPow(int a, int b) {
        if(b == 1) return a % k;
        if(b == 0) return 1;
        
        int halfModePow = modPow(a, b/2);
        if(b % 2 == 0) {
            return halfModePow * halfModePow % k;
        } else {
            return ((a % k) * (halfModePow * halfModePow % k)) % k;
        }
    }
    
    public static void main(String[] args) {
    	SuperPow x = new SuperPow();
    	int[] b = {2,0,0};
		System.out.println(x.superPow(2147483647, b));
	}
}
