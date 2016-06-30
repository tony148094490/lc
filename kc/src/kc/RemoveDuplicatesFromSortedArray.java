package kc;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesFromSortedArray a = new RemoveDuplicatesFromSortedArray();
		int[] arr = {1,2,3,4,5,6,6,6,7,8,9};
		System.out.println(a.removeDuplicates(arr));
		for(Integer x : arr)
		System.out.println(x);
	}

    public int removeDuplicates(int[] nums) {
    	if(nums.length == 0) return 0;
    	
    	int l = 0;
    	int r = 0;

    	while(r < nums.length) {
    		
        	while(r < nums.length && nums[r] == nums[l] ) {
        		r++;
        	}
    		if(r == nums.length) break;
        	
    		l++;
    		if(l < r) {
    			helper(nums,l,r);
    		}
    		r++;
    	}
    	return l+1;
    }
    
    private void helper(int[] arr, int l, int r) {
    	int temp = arr[r];
    	arr[r] = arr[l];
    	arr[l] = temp;
    }
}
