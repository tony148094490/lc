package kc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
    	Arrays.sort(nums);
    	for(int i = 1; i < nums.length; i++){
    		if(nums[i] == nums[i-1]) return true;
    	}
    	return false;
    }
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) {
                int lastPos = map.get(nums[i]);
                if (i - lastPos <= k) return true;
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) return false;
        
        //bucketing based on value
        long range = (long) t + 1; // for t = 0
        Map<Long, Long> buckets = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            long offsetNumber = (long) (nums[i]) - Integer.MIN_VALUE; // to avoid {-4, 4} t = 5;

            long thisBucket = offsetNumber / range;
            if(buckets.containsKey(thisBucket) || 
            		(buckets.containsKey(thisBucket-1) && offsetNumber - buckets.get(thisBucket-1) <= t) ||
            		(buckets.containsKey(thisBucket+1) && buckets.get(thisBucket+1) - offsetNumber <= t))
                return true;
            if(buckets.size() == k) {
                long firstBucket = ((long) (nums[i-k]) - Integer.MIN_VALUE) / range;
                buckets.remove(firstBucket);
            }
            buckets.put(thisBucket, offsetNumber);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    	ContainsDuplicate x = new ContainsDuplicate();
    	int[] arr = new int[3];
    	arr[0] = 1;
    	arr[1] = 3;
    	arr[2] = 1;
    	System.out.println(x.containsNearbyAlmostDuplicate(arr, 1, 1));
	}
}
