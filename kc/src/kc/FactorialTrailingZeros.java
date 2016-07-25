package kc;

public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
    	int c = 0;
    	long five = 5;
    	
    	while(n / five > 0) {
    		c += n/five;
    		five = five * 5;
    	}
    	
    	return c;
    }
    
    public int trailingZeroes2(int n) {
    	int c = 0;
    	int five = 5;
    	
    	while(n > 0) {
    		c += n/five;
            n = n / five;
        	}
    	return c;
    	}
    public static void main(String[] args) {
		FactorialTrailingZeros x = new FactorialTrailingZeros();
		System.out.println(x.trailingZeroes(1808548329));
	}
}
