package kc;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        
        int res = 10;
        int nine = 9;
        int nine2 = 9; 
        for(int i = 2 ; i <= n && nine2>0; i++ ) {
        	nine = nine * nine2;
        	res = res + nine;
        	nine2--;
        }
        return res;
    }
    
    public static void main(String[] args) {
    	CountNumbersWithUniqueDigits x = new CountNumbersWithUniqueDigits();
    	System.out.println(x.countNumbersWithUniqueDigits(2));
	}
}
