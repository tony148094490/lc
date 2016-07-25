package kc;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int c = 0;
        int res = 0;
        while(c < 32) {
            int current = n & 1;
            res = (res << 1) + current;
            c++;
            n = n >> 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
		ReverseBits x = new ReverseBits();
		System.out.println(x.reverseBits(43261596));
	}
    
}
