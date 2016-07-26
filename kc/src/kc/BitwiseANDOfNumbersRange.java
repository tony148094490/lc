package kc;

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if(m>n) return rangeBitwiseAnd(n,m);
        
        int res = 0;
        int c = 0;
        long one = 1;
        while(m >= one) {
            c = (int) ((m & one) & (n & one));
            
            if(c != 0) {
                if(n - m < one) {
                    res += one;
                }
            } 
                one = one * 2;
        }
        return res;
    }
    public static void main(String[] args) {
    	BitwiseANDOfNumbersRange x = new BitwiseANDOfNumbersRange();
    	System.out.println(x.rangeBitwiseAnd(2147483646,2147483647));
	}
    
}
