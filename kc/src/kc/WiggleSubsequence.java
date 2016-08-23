package kc;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return nums.length;
        int res = 1;
        boolean prevIsPositive = true;
        int i = 1;
        while(i < nums.length && nums[i] == nums[0]) i++;
        if(i == nums.length) return 1;
        if(nums[i] < nums[0]) {
        	prevIsPositive = false;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if(prevIsPositive) {
        	max = nums[i];
        } else {
        	min = nums[i];
        }
        
        res++;
        for(int j = i + 1; j < nums.length; j++) {
        	if(prevIsPositive) {
        		if(nums[j] < max) {
        			res++;
        			max = Integer.MAX_VALUE;
        			min = nums[j];
        			prevIsPositive = false;
        		} else {
        			max = nums[j];
        		}
        	} else {
        		if(nums[j] > min) {
        			res++;
        			max = nums[j];
        			min = Integer.MIN_VALUE;
        			prevIsPositive = true;
        		} else {
        			min = nums[j];
        		}
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
    	WiggleSubsequence x = new WiggleSubsequence();
    	int[] arr = {1,2,3,4,5,6,7,8,9};
    	System.out.println(x.wiggleMaxLength(arr));
	}
}
