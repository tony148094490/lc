package kc;

public class ReverseInteger {
	
	public int reverse(int x) {
		int res = 0;
		boolean neg = x < 0 ? true : false;
		if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) return 0;
		x = Math.abs(x);
		int modulo = 0;
		while (x > 0) {
			modulo = x % 10;
			
			if (res * 10 / 10 !=  res) return 0;
			
			res =  (res * 10) + modulo;
			x = x / 10;
		}
		return neg == true ? res * (-1) : res;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(1534236469));
	}

}
