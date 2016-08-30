package kc;
/**
Given an unsorted integer array, find the first missing positive integer.
For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
Your algorithm should run in O(n) time and uses constant space. 
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
    	int legit = nums.length;
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] >= 1 && nums[i] <= legit && (nums[i] != nums[nums[i]-1])) {
        		if(nums[i] != i + 1) {
        			swap(nums,i, nums[i] - 1);
        			i--;
        		}
        	}
        }
        
        for(int i = 0 ; i < nums.length ;i++) {
        	if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
    
    private void swap(int[] arr, int l, int r) {
    	int temp = arr[l];
    	arr[l] = arr[r];
    	arr[r] = temp;
    }
}
