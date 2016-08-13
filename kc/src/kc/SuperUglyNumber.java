package kc;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 0) return 0;
    	int[] uglies = new int[n];
        uglies[0] = 1;
        
        int[] prime = new int[primes.length];
        
        for(int i = 1; i < n; i++) {
        	uglies[i] = Integer.MAX_VALUE;
        	for(int j = 0 ; j < primes.length; j++) {
        		uglies[i] = Math.min(primes[j] * uglies[prime[j]], uglies[i]);
        	}
        	for(int j = 0 ; j < primes.length; j++) {
        		while(primes[j] * uglies[prime[j]] <= uglies[i]) prime[j]++;
        	}
        }
        
        
        return uglies[n - 1];
    }
    
    public static void main(String[] args) {
		int[] primes = {3,5,7,11,19,23,29,41,43,47};
		SuperUglyNumber x= new SuperUglyNumber();
		for(int i = 1 ; i <=15; i++)
		System.out.println(x.nthSuperUglyNumber(i, primes));
	}
}
