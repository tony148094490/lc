package kc;

public class BitwiseANDOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        if(m > n) return rangeBitwiseAnd(n, m);
        long one = 1;
        int res = 0;
        while(one <= m) {
            int cur = (int) ((m&one) & (n&one));
            
            // it takes 'one' nr of numbers to flip position at 'one', if there are less than that many
            // numbers between m and n, then that bit stay put
            if(cur != 0 && (n-m) < one) {
                res+=one;
            }
            one = (one << 1);
        }
        return res;
    }
    
    public static void main(String[] args) {
    	BitwiseANDOfNumbersRange x = new BitwiseANDOfNumbersRange();
    	System.out.println(x.rangeBitwiseAnd(2147483646,2147483647));
	}
    
}
