package fb;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for(int n : nums) {
            if(map.containsKey(n)) continue;
            if(map.containsKey(n-1) && map.containsKey(n+1)) {
                map.put(n, 1);
                int left = map.get(n-1);
                int right = map.get(n+1);
                map.put(n - left, left + right + 1);
                map.put(n + right, left + right + 1);
                max = Math.max(left + right + 1, max);
            } else if(map.containsKey(n-1)) {
                int left = map.get(n-1);
                map.put(n - left, left + 1);
                map.put(n, left + 1);
                max = Math.max(max, left + 1);
            } else if(map.containsKey(n+1)) {
                int right = map.get(n+1);
                map.put(n + right, right + 1);
                map.put(n, right + 1);
                max = Math.max(max, right + 1);
            } else {
                map.put(n, 1);
            }
        }
        
        return max;
    }
}
