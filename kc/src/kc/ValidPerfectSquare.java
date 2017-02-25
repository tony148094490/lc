package kc;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num<=0) return false;
        for(int i = 1 ; i * i > 0 && i * i <= num; i++) {
            if(num == i * i) return true;
        }
        return false;
    }
    
    public boolean isPerfectSquare2(int num) {
        if(num == 1) return true;
        if(num < 0) return false;
        long left = 0;
        long right = (long) num/2;
        while(left <= right) {
            long mid = (long) left + (long) (right - left) / 2;
            if(mid * mid < num) {
                left = mid + 1;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
