package kc;

public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(z == 0) return true;

        if(x == 0) return y == z;
        if(y == 0) return x == z;
        
        int gcd = GCD(x, y);
        
        return z % gcd == 0;
    }
    
    private int GCD(int x, int y) {
        if(y == 0) return x;
        return GCD(y, x%y);
    }
}
