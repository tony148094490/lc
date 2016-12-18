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
        if(nums.length < 2) return 0;
        
        int[] mins = new int[nums.length];
        int[] maxs = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            mins[i] = Integer.MAX_VALUE;
            maxs[i] = Integer.MIN_VALUE;
        }
        
        int bucketSize = (int) Math.ceil((max - min) / ((double) nums.length-1));
        if(bucketSize == 0) return 0;
        
        for(int i = 0 ; i < nums.length; i++) {
            
            int bucket = (nums[i] - min)/ bucketSize;
            mins[bucket] = Math.min(mins[bucket], nums[i]);
            maxs[bucket] = Math.max(maxs[bucket], nums[i]);
        }
        
        int res = Integer.MIN_VALUE;
        
        int last = min;
        for(int i = 0 ; i < nums.length; i++) {
                if(mins[i] == Integer.MAX_VALUE && maxs[i] == Integer.MIN_VALUE) continue;
                res = Math.max(res, mins[i] - last);
                last = maxs[i];
        }
        
        return res;
    }
}
