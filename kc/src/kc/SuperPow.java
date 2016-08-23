package kc;

public class SuperPow {
    public int superPow(int a, int[] b) {
    	int ans = 1;
    	if (a == 1337) return 0;
    	a = a % 1337;
    	for(int i = 0 ; i < b.length; i++) {
    		ans = ((pow(ans, 10) * pow(a, b[i]))) % 1337;
    	}
    	return ans;
    }
    
    private int pow (int a, int b) {
    	if(b == 1) return a;
    	if(b == 0) return 1;
    	int half = pow(a, b/2);
    	int res = 1;
    	if(b % 2 != 0) {
    		res = (a * (half * half % 1337)) % 1337;
    	} else {
    		res = half * half % 1337;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	SuperPow x = new SuperPow();
    	int[] b = {2,0,0};
		System.out.println(x.superPow(2147483647, b));
	}
}
