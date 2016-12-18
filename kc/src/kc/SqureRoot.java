package kc;

public class SqureRoot {
	
	private static final double t = 0.000001;
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return x;
        int l = 1;
        int r = x;
        int ans = 0;
        while(l <= r) {
            int m = l + (r-l)/2;
            if(m * m == x) return m;
            if(m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
                ans = m;

            }
        }
        return ans;
    }
    
    
    public int mySqrt2(int x) {
    	
    	double initial = x/2;
    	
    	while(Math.abs(initial * initial - x) >= t ) {
    		initial = (initial + x/initial) / 2;
    	}
    	return (int) initial;
    }
    
    public static void main(String[] args) {
    	SqureRoot x = new SqureRoot();
    	System.out.println(x.mySqrt2(125));
    }
}
