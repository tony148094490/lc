package kc;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] A) {
    	Map<Integer,Integer>[] map = new Map[A.length];
    	int res = 0;
    	for(int i = 0 ; i < A.length; i++) {
    		map[i] = new HashMap<>();
    		for(int j = 0 ; j < i; j++) {
    			int diff = A[i] - A[j];
    			int potential = map[j].getOrDefault(diff,0);
    			res += potential;
    			int existing = map[i].getOrDefault(diff, 0);
    			map[i].put(diff, potential + existing + 1);
    		}
    	}
    	return res;
    }
}
