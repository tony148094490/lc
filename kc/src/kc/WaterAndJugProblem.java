package kc;

public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(x == z || y == z || x + y == z) return true;
        return z % gcd(x, y) == 0;
    }
    
    private int gcd(int x, int y) {
        if( x > y) return gcd(y, x);
        if( x == 1 || y == 1) return 1;
        while(x != 0) {
            int temp = x;
            y = y % x;
            x = y;
            y = temp;
        }
        
        return y;
    }
}
