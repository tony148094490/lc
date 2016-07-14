package kc;

public class RemoveDuplicatesFromSortedList {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        
        int start = 0;
        int end = 0;
        
        while(end + 1 < nums.length) {
        	if(nums[end] == nums[end + 1]){
        		nums[start] = nums[end];
        		nums[start+1] = nums[end];
        		start = start + 2;
        	} else {
        		nums[start] = nums[end];
        		start = start + 1;
        	}
        	
        	do {
        		end++;
        	} while(end < nums.length && nums[end] == nums[end-1]);
        }
        
        if((end == nums.length - 1) && (nums[end] != nums[end-1])) {
        	nums[start] = nums[end];
        	start = start + 1;
        } 
        
        return start;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,1,1,2,2,3};
    	RemoveDuplicatesFromSortedArrayII x = new RemoveDuplicatesFromSortedArrayII();
    	int b = x.removeDuplicates(nums);
    	System.out.println(b);
    	for(Integer a : nums) {
    		System.out.print(a + ",");
    	}
    }
}
