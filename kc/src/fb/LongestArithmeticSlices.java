package fb;

import java.util.HashMap;
import java.util.Map;

// and with path ?
public class LongestArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        Map<Long, Integer>[] map = new Map[A.length];
        int res = 0;
        for(int i = 0 ; i < A.length; i++) {
            map[i] = new HashMap<>();
            for(int j = i  - 1; j >= 0 ; j--) {
                long diff = (long) A[i] - (long) A[j];
                if(diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) continue;
                int existing = map[j].getOrDefault(diff, 0);
                res += existing;
                
                int newOne = map[i].getOrDefault(diff, 0);
                map[i].put(diff, newOne + existing + 1);
            }
        }
        return res;
    }
}
