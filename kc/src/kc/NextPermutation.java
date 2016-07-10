package kc;

public class NextPermutation {

	// This is to rearrange numbers according numbers lexicographically 
	// 123 -> 132 -> 213 -> 231 -> 312 -> 321
    public void nextPermutation(int[] nums) {
    	if (nums.length < 2) return;
    	//From the end, find the first decreasing position
    	int p = nums.length - 2;
    	while(p >= 0 && nums[p] >= nums[p+1]) {
    		p--;
    	}
    	if(p == -1) {
    		reverse(nums, 0, nums.length-1);
    		return;
    	}
    	
    	// 15432 -> 21345, 21543 -> 23145 
    	//Find the next smallest number starting from n
    	reverse(nums,p+1,nums.length-1);
    	int q = p;
    	while(nums[p]>=nums[q]) q++;
    	swap(nums,p,q);
    }
    
    
    private void reverse(int[] arr, int start, int end) {
    	while( start < end) {
    		swap(arr,start,end);
    		start++;
    		end--;
    	}
    }
    private void swap(int[] arr, int left, int right) {
    	int temp = arr[left];
    	arr[left] = arr[right];
    	arr[right] = temp;
    }
    
    public static void main(String[] args) {
    	int[] arr = {2,3,1};
    	NextPermutation x = new NextPermutation();
    	x.nextPermutation(arr);
    	for(Integer a : arr)
    	System.out.print(a + "->");
    }
	
}
