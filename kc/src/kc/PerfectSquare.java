package kc;

public class PerfectSquare {
    public int numSquares(int n) {
    	if(n <= 0) return n;
    	
    	int[] arr = new int[n+1];
    	for(int i = 0 ; i <= n ;i++) {
    		arr[i]  = i;
    	}
    	
    	for(int i = 1; i <= n ;i++ ) {
    		for(int j = 1 ; j * j <= i ; j++ ) {
    			arr[i] = Math.min(arr[i - j * j] + 1 , arr[i]);
    		}
    	}
    	return arr[n];
    }
    public static void main(String[] args) {
    	PerfectSquare x = new PerfectSquare();
    	System.out.println(x.numSquares(9));
	}
}
