package kc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Frog {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
		if(stones.length == 2 && stones[1] > 1) return false;
		if(stones.length == 2 && stones[1] == 1) return true;
		
		for(int x : stones) {
			map.put(x, new HashSet<>());
		}
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		map.put(0, set);
		
		for(int i = 0; i < stones.length-1; i++) {
			for(int step : map.get(stones[i])) {
				for(int j = -1; j <= 1; j++) {
					if(stones[i] + step + j == stones[stones.length-1]) return true;
					
					if(stones[i] + step + j == stones[i]) continue;
					
					Set<Integer> newSet = map.get(stones[i] + step + j);
					if(newSet == null) continue;
					newSet.add(step + j);	
				}
			}
		}

		return false;
    }
	
	public static void main(String[] args) {
		int[] arr = {0,1,3,4,5,7,9,10,12};
		Frog x = new Frog();
		System.out.println(x.canCross(arr));
	}
}
