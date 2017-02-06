package kc;

public class UglyNumber {
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        if(num == 1) return true;
        while(num%2 == 0) num/=2;
        while(num%3 == 0) num/=3;
        while(num%5 == 0) num/=5;
        if(num != 1) return false;
        return true;
    }
    
    public int nthUglyNumber(int n) {
        if(n <= 6) return n;
        int two = 1;
        int three = 1;
        int five = 1;
        
        int[] uglies = new int[n+1];
        for(int i = 1; i <= 6; i++) {
            uglies[i] = i;
        }
        int twoCur = 1;
        int threeCur = 1;
        int fiveCur = 1;
        int counter = 6;
        while(counter < n) {
            while(twoCur <= uglies[counter]) {two++; twoCur = uglies[two] * 2;}
            while(threeCur <= uglies[counter]) {three++; threeCur = uglies[three] * 3;}
            while(fiveCur <= uglies[counter]) {five++; fiveCur = uglies[five] * 5;}
            counter++;
            if(twoCur <= threeCur && twoCur <= fiveCur) {
                uglies[counter] = twoCur;
            } else if(threeCur <= fiveCur && threeCur <= twoCur) {
                uglies[counter] = threeCur;
            } else {
                uglies[counter] = fiveCur;
            }
        }
        return uglies[n];
    }
    
    public static void main(String[] args) {
    	UglyNumber x = new UglyNumber();
    	System.out.println(x.nthUglyNumber(10));
	}
}
