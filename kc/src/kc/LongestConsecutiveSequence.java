package kc;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        
        for(Integer x : nums) {
        	if(map.containsKey(x)) continue;
        	int cur = 1;
        	if(map.containsKey(x+1) && map.containsKey(x-1)) {
        		int rightLen = map.get(x+1);
        		int leftLen = map.get(x-1);
        		map.put(x+1 + map.get(x+1) - 1, rightLen + leftLen + 1);
        		map.put(x-1 - map.get(x-1) + 1, rightLen + leftLen + 1);
        		map.put(x, rightLen+leftLen+1);
        		cur = rightLen+leftLen+1;
        	}else if(map.containsKey(x+1)) {
        		int rightLen = map.get(x+1);
        		map.put(x+1 + map.get(x+1) - 1, rightLen+1);
        		map.put(x+1, rightLen+1);
        		map.put(x, rightLen+1);
        		cur = rightLen+1;
        	}else if(map.containsKey(x-1)) {
        		int leftLen = map.get(x-1);
        		map.put(x-1 - map.get(x-1) + 1, leftLen + 1);
        		map.put(x-1, leftLen + 1);
        		map.put(x, leftLen+1);
        		cur = leftLen + 1;
        	} else {
        		map.put(x, 1);
        	}
        	max = Math.max(max, cur);
        }
        return max;
    }
}
