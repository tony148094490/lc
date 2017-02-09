package kc;

import java.util.HashMap;
import java.util.Map;
/**
 * idea is to use range sum and see if there is a j so that sum[i] - sum[j] = k by using a hash table 
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums.length == 0) return 0;
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        int res = 0;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for(int i = 0 ; i < nums.length; i++) {
            if(map.containsKey(nums[i] - k)) {
                res = Math.max(res, i - map.get(nums[i] - k));
            }
            
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
