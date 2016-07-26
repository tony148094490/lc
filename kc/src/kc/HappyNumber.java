package kc;


public class HappyNumber {
    public boolean isHappy(int n) {
    	if(n == 1 ) return true;
    	
        long slow = getNumber(n);
        long fast = getNumber(n);
        do {slow = getNumber(slow);
        	fast = getNumber(fast);
        	fast = getNumber(fast);
        	} while(slow != fast);
        if(slow == 1) return true;
        return false;
    }
    
    private long getNumber(long a) {
    	long res = 0;
    	while(a > 0) {
    		res += (a % 10) * (a % 10);
    		a /= 10;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	HappyNumber x = new HappyNumber();
    	System.out.println(x.isHappy(19));
	}
}
