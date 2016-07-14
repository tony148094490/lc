package kc;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    
    private boolean binarySearch(int[] nums, int target, int l, int r) {
    	
    	if(l > r) return false;
    	
    	int m = (l + r) / 2;
    	
    	if(nums[m] == target) {
    		return true;
    	} else if(nums[m] < nums[r] && target < nums[m]){
    		return binarySearch(nums,target,l,m-1);
    	} else if(nums[m] > nums[l] && target > nums[m]){
    		return binarySearch(nums,target,m+1,r);
    	} else {
    		boolean left = binarySearch(nums,target,l,m-1);
    		if(left) return true;
    		return binarySearch(nums,target,m+1,r);
    	}
    	
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,2,2,2,2,2,2,3,4,0,0,0};
    	SearchInRotatedSortedArrayII x = new SearchInRotatedSortedArrayII();
    	System.out.println(x.search(arr, 5));
    	
    }
}
