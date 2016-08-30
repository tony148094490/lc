package kc;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        return helper(nums,0,nums.length-1,target);
    }
    
    private int helper(int[] nums, int l, int r, int target) {
        if(l > r) return -1;
        int mid = nums[(l + r)/2];
        int m = (l+r)/2;
        if(mid == target) return m;
        
        if(mid < target) {
            if(mid <= nums[r]) {
                if(nums[r] >= target) {
                    return helper(nums,m+1,r,target);
                } else {
                    return helper(nums,l,m-1,target);
                }
            } else {
                return helper(nums,m+1,r,target);
            }
        } else {
            if (mid >= nums[l]) {
                if(nums[l] <= target) {
                    return helper(nums,l,m-1,target);
                } else {
                    return helper(nums,m+1,r,target);
                }
            } else {
                return helper(nums,l,m-1,target);
            }
        }
    }
    
    public static void main(String[] args) {
    	SearchInRotatedSortedArray x = new SearchInRotatedSortedArray();
    	int[] arr = {5,1,3};
    	System.out.println(x.search(arr, 5));
	}
}
