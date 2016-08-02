package kc;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        int nrOfOneBit = 0;
        while( n > 0) {
            if((n & 1) == 1) nrOfOneBit++;
            if(nrOfOneBit > 1) return false;
            n = n >> 1;
        }
        return true;
    }
    public static void main(String[] args) {
		IsPowerOfTwo x = new IsPowerOfTwo();
		System.out.println(x.isPowerOfTwo(2));
	}
}
