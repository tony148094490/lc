package kc;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for(int x : nums) {
            if(map.containsKey(x)) continue;
            int len = 1;
            if(map.containsKey(x-1) && map.containsKey(x+1)) {
                int left = map.get(x-1);
                int right = map.get(x+1);
                map.put(x-left, left+right+1);
                map.put(x+right, left+right+1);
                map.put(x, -1);//dummy for dedupe
                len = left + right + 1;
            } else if(map.containsKey(x+1)) {
                int right = map.get(x+1);
                map.put(x+right, right + 1);
                map.put(x, right + 1);
                len = right + 1;
            } else if(map.containsKey(x-1)) {
                int left = map.get(x-1);
                map.put(x-left, left+1);
                map.put(x, left+1);
                len = left + 1;
            } else {
                map.put(x,1);
            }
            max = Math.max(len, max);
        }
        return max;
    }
}
