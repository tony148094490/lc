package kc;

public class NumberOfDigitOne {
    public int countDigitOne(int n) {
    	int ans = 0;
    	long starting = 1;
    	long divisor = 10;
    	while(n/starting > 0) {
    		long upper = n / divisor * starting;
    		long digit = (n / starting) % 10;
    		long lower = n - (n/starting) * starting;
    		
    		if(digit == 0) {
    			ans += upper;
    		} else if(digit == 1) {
    			ans += (upper + 1 + (lower));
    		} else {
    			ans += (upper + starting);
    		}
    		
    		divisor = divisor * 10;
    		starting = starting * 10;
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
    	NumberOfDigitOne x = new NumberOfDigitOne();
    	System.out.println(x.countDigitOne(1410065408));
	}
}
