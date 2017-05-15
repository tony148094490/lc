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
    
    public int findMin2(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        return bs(nums, 0, nums.length-1);
    }
    private int bs(int[] arr, int start, int end) {
        if(start == end) return arr[start];
        if(start == end - 1) return Math.min(arr[start], arr[end]);
        
        int mid = start + (end - start) / 2;
        
        if(arr[start] == arr[mid] && arr[mid] == arr[end]) return Math.min(bs(arr, start,mid-1), bs(arr, mid+1,end));
        if(arr[start] == arr[mid]) {
            if(arr[mid] > arr[end]) {
                int left = bs(arr, mid+1,end);
                return Math.min(left, arr[start]);
            } else {
                return arr[start];
            }
        } else if(arr[mid] == arr[end]) {
            if(arr[mid] > arr[start]) {
                return arr[start];
            } else {
                int right = bs(arr, start, mid-1);
                return Math.min(right, arr[end]);
            }
        } else {
            if(arr[start] < arr[mid] && arr[mid] < arr[end]) {
                return arr[start];
            } else if(arr[start] < arr[mid]) {
                return bs(arr, mid+1, end);
            } else {
                return bs(arr, start, mid-1);
            }
        }
        

    }
    
    public static void main(String[] args) {
    	FindMinimumInRotatedSortedArrayII x = new FindMinimumInRotatedSortedArrayII();
    	int[] arr = {3,1,3};
    	System.out.println(x.findMin2(arr));
    }
}
