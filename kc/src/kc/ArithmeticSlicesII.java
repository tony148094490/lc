package kc;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[A.length];
        for(int i = 0 ; i < A.length; i++) {
            map[i] = new HashMap<>();
            for(int j = 0 ; j < i ; j++) {
                long diff = (long) A[i] - A[j];
                if(diff >= Integer.MAX_VALUE || diff <= Integer.MIN_VALUE) continue;
                int d = (int) diff;
                int potentialNew = map[j].getOrDefault(d,0);
                int existing = map[i].getOrDefault(d,0);
                res += potentialNew;
                map[i].put(d, potentialNew + existing + 1);
            }
        }
    
        return res;
    }
}
