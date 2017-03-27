package kc;

public class Pow {

    public double myPow(double x, int n) {
    	if(x == 0 || x == 1) return x;
    	
    	if(n == 0) return 1;
    	if(n == 1) return x;
    	if(n == -1) return 1/x;
    	
    	
    	if(n % 2 == 0) {
        	double squareRoot = myPow(x, n/2);

        	return squareRoot * squareRoot;

    	} else {
    		if ( n > 0) {
    			double squareRoot = myPow(x, (n - 1) / 2);
    			return x * squareRoot * squareRoot;
    		} else {
    			double squareRoot = myPow(x, (n + 1)/2);
    			return (1/x) * squareRoot * squareRoot;
    		}
    	}
    	

    }
	
    public double myPow2(double x, int n) {
        if(n == 1) return x;
        if(n == 0) return 1;
        if(n == -1) return 1/x;
        
        double half = myPow(x, n/2);
        if( n % 2 != 0) {
            if(n > 0) 
            return half * half * x;
            return half * half * (1/x);
        } else {
            return half * half;    
        }
    }
    
	public static void main(String[] args) {
	
		
		Pow s = new Pow();
		System.out.println(s.myPow(34.00515, -3));
		System.out.println(s.myPow2(34.00515, -3));
		
	}
}
