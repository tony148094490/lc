package kc;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        
        return a;
    }
    
    public static void main(String[] args) {
    	SumOfTwoIntegers a = new SumOfTwoIntegers();
    	System.out.println(a.getSum(3, 2));
	}
}
