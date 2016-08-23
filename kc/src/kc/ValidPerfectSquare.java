package kc;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num<=0) return false;
        for(int i = 1 ; i * i > 0 && i * i <= num; i++) {
            if(num == i * i) return true;
        }
        return false;
    }
}
