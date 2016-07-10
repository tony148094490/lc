package kc;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        
        int end = nums.length - 1;
        int start = 0;
        
        while(start < end) {
        	if(nums[start] == val) {
        		swap(nums,start,end);
        		end--;
        	}else {
        		start++;
        	}
        }
        if(nums[start] == val) {
        	return start;
        } else {
        	return start + 1;
        }
    }
    
    private void swap (int[] arr, int a, int b) {
    	int temp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = temp;
    }
    
    public static void main(String[] args) {
    	int[] arr = {3,2,2,3};
    	RemoveElement x = new RemoveElement();
    	System.out.println("This is the length " + x.removeElement(arr, 3));
    	for(Integer r : arr) {
    		System.out.println(r);
    	}
    }
}
