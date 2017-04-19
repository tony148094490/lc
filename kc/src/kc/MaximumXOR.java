package kc;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOR {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int one = 0;
        for(int i = 31; i >= 0 ;i--) {
            one |= 1 << i;
            Set<Integer> set = new HashSet<>();
            for(int x : nums) set.add(x & one);
            int potential = max | (1<<i);
            for(Integer a : set) {
                if(set.contains(potential ^ a)) {
                    max = potential;
                    break;
                }
            }
        }
        return max;
    }
}
