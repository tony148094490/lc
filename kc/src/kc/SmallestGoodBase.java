package kc;

public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        int digit = 62;
        while((1L << digit) > num) digit--;

        for(int i = digit; i >= 0 ; i--) {
            long res = getBase(num, i);
            if(res != -1) return String.valueOf(res);
        }
        return String.valueOf(num-1);
    }
    
    private long getBase(long num, int digit) {
        long l = 0; long r = (long) Math.pow(num, 1.0/digit) + 1;
        while(l <= r) {
            long m = l + (r-l) / 2;
            long cur = 1;
            long sum = 0;
            for(int i = 0; i <= digit; i++) {
                sum += cur;
                cur *= m;
            }
            if(sum == num) return m;
            if(sum < num) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return -1;
    }
}
