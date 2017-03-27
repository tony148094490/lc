package kc;

public class DivideTwoIntegers {
	
	//Return Integer.MAX_VALUE if it overflows
    public int divide(int dividend, int divisor) {
    	long divid =  Math.abs((long) dividend);
    	long divir =  Math.abs((long) divisor); 
    	
    	if (divir > divid) return 0;
    	if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
    	
    	int sign = 1;
    	if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
    		sign = -1;
    	}
    	
    	int res = 0;
    	long temp = 0;
    	int c = 0;
    	int current = 0;
    	while(divid >= divir) {
	    	c = 0;
	    	current = 0;
	    	temp = divir;
	    	while(temp <= divid) {
	    		temp <<= 1;
	    		c++;
	    	}
	    	temp >>= 1;
	    	c--;
	    	
	    	divid = divid - (divir << c);

	    	res = res + (1<<c);
	
	    }
    	return res * sign;
    }
    
    public int divide2(int dividend, int divisor) {
        long divd = Math.abs((long) dividend);
        long divr = Math.abs((long) divisor);
        System.out.println(divd);
        System.out.println(divr);
        
        int res = 0;
        boolean neg = false;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) neg = true;
        if(dividend == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        while(divd >= divr) {
            int c = 0; 
            while((divr << c) <= divd) c++;
            c = c - 1;
            long cur = 1;
            divd -= (divr << c);
            
            cur <<= c;
            
            res += cur;
        }
        
        return res * (neg == true ? -1 : 1);
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide2(-2147483648, 1));
	}

}
