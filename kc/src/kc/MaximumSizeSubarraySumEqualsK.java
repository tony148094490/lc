package kc;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
    	if(nums.length == 0) return 0;
    	int[] sums = new int[nums.length];
    	sums[0] = nums[0];
    	for(int i = 1 ; i < nums.length; i++) {
    		sums[i] = nums[i] + sums[i-1];
    	}
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0 ; i < sums.length; i++) {
        	if(sums[i] == k) {
        		max = i + 1;
        	} else if(map.containsKey(sums[i] - k)) {
        		max = Math.max(max, i - map.get(sums[i] - k));
        	}
        	if(!map.containsKey(sums[i])) {
    			map.put(sums[i], i);
    		}
        }
        return max;
    }
}
