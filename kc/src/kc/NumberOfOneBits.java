package kc;

public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int a = 1;
        int res = 0;
        
        while(a < 32 ) {
            if ((n & 1) == 1) res++;
            a++;
            n = n >> 1;
        }
        
        if(n != 0) res++;
        return res;
    }
    
    public static void main(String[] args) {
		NumberOfOneBits x = new NumberOfOneBits();
		System.out.println(x.hammingWeight(  0 ));
	}
}
