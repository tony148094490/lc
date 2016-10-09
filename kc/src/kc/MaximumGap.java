package kc;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 *
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
    	if(nums.length <= 1) return 0;

    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;

    	for(Integer x : nums) {
    		max = Math.max(max, x);
    		min = Math.min(min, x);
    	}

    	int gap = (int) Math.ceil((max - min)/(nums.length - 1));

    	int[] maxs = new int[nums.length - 1];
    	int[] mins = new int[nums.length - 1];

    	Arrays.fill(maxs, Integer.MIN_VALUE);
    	Arrays.fill(mins, Integer.MAX_VALUE);

    	for(Integer x : nums) {
    		if(x == min || x == max) continue;
    		int bucket = (x - min) / gap;
    		maxs[bucket] = Math.max(maxs[bucket], x);
    		mins[bucket] = Math.min(mins[bucket], x);
    	}

    	int maxGap = Integer.MIN_VALUE;
    	int last = min;

    	for(int i = 0 ; i < maxs.length; i++) {
    		if(maxs[i] == Integer.MIN_VALUE && mins[i] == Integer.MAX_VALUE) continue;
    		maxGap = Math.max(maxGap, mins[i] - last);
    		last = maxs[i];
    	}

    	maxGap = Math.max(maxGap, max - last);

    	return maxGap;
    }
}
