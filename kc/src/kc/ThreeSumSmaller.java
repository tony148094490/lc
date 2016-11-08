package kc;

import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0 ; i < nums.length - 2; i++) {
        	int left = i + 1;
        	int right = nums.length - 1;
        	while(left < right) {
        		if(nums[i] + nums[left] + nums[right] < target) {
        			res += right - left;
        			left++;
        		} else {
        			right--;
        		}
        	}
        }
        return res;
    }
}

