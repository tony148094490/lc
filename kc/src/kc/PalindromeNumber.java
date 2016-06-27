package kc;

public class PalindromeNumber {

	//Space O(1), Time O(N) where N is the number of x's digit
	public boolean isPalindrome(int x) {
		if (x < 0 ) return false;
		if(x < 10) return true;
		int res = x;
		
		int numOfZeros = 1;	
		while(res >= 10) {
			numOfZeros *= 10;
			res = res/10;
		}
		res = x;

		while( res > 0 ){
			if(numOfZeros > res) {
				if(res % 10 != 0) return false;
				res = res / 10;
			}else {
				if(res / numOfZeros != res % 10) return false;
				res = (res - res / numOfZeros * numOfZeros) / 10;
			}	
			numOfZeros = numOfZeros / 100;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(121));
	}
}
