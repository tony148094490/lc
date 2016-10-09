package kc;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private int helper(int[] nums, int l, int r) {
    	if(l >= r) return nums[l];
    	
    	int m = (l + r) / 2;
    	
    	if(nums[m] < nums[r]) {
    		return helper(nums, l, m);
    	} else if (nums[m] > nums[r]){
    		return helper(nums, m+1,r);
    	} else {
    		if(nums[l] < nums[m]) {
    			return helper(nums, l, m-1);
    		} else if (nums[l] > nums[m]){
    			return helper(nums, l, m);
    		} else {
    			int left = helper(nums, l, m-1);
    			int right = helper(nums, m+1, r);
    			return Math.min(left, right);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	FindMinimumInRotatedSortedArrayII x = new FindMinimumInRotatedSortedArrayII();
    	int[] arr = {3,3,1,3};
    	System.out.println(x.findMin(arr));
    }
}
