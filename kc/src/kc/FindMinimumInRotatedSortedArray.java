package kc;

public class FindMinimumInRotatedSortedArray {
	
    public int findMin(int[] nums) {
    	if(nums.length == 0) return -1;
        return get(nums,0,nums.length-1);
    }
    
    private int get(int[] arr, int l, int r) {
    	if(l >= r) {
    		return arr[l];
    	}
    	
    	int m = (l + r ) / 2;
    	
    	if(arr[m] > arr[r]) {
    		return get(arr, m + 1, r);
    	} else {
    		return get(arr,l,m);
    	}
    }
	
	public static void main(String[] args) {
		int[] arr = {3,1,2};
		FindMinimumInRotatedSortedArray x = new FindMinimumInRotatedSortedArray();
		System.out.println(x.findMin(arr));
	}
}
