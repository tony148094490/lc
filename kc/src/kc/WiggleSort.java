package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
    //	if(nums.length < 3) return;
    	int median = findKthLargest(nums, nums.length%2 == 0 ? nums.length/2 - 1 : nums.length/2, 0, nums.length-1);
    	Arrays.sort(nums);
    	List<Integer> small = new ArrayList<Integer>();
    	List<Integer> big = new ArrayList<Integer>();

    	for(int i = 0 ; i <= median ; i++) {
    		small.add(nums[i]);
    	}

    	for(int i = median+1;i<nums.length;i++) {
    		big.add(nums[i]);
    	}
    	
    	for(Integer x : nums) System.out.print(x + ",");
    	System.out.println();
  	System.out.println(small);
  	System.out.println(big);
  	System.out.println(median);
  	
    	int i = 0, ls = 0, rs = 0;
    	
    	for(i = 0, ls = small.size()-1, rs = big.size()-1; i <= nums.length - 2 && ls>=0 && rs>=0 ; i+=2, rs--, ls-- ) {
    		nums[i] = small.get(ls);
    		nums[i+1] = big.get(rs);
    	}
    	
    	if(i == nums.length - 1) {
    		nums[i] = small.get(0);
    	}
    	
    }
    
    private int findKthLargest(int[] arr, int k, int l, int r) {
    	if(l == r) return l;
    	
    	int sorted = partition(arr, l, l+1, r);
    	
    	if(sorted == k) return sorted;
    	
    	if(sorted < k) {
    		return findKthLargest(arr,k, sorted+1,r);
    	} else {
    		return findKthLargest(arr,k, l, sorted-1);
    	}
    }
 
	private int partition(int[] arr, int pivotIndex, int leftMost, int rightMost) {
		int end = rightMost;
		int start = pivotIndex;
		
		while (true) {
			while (leftMost < end  && arr[leftMost] <= arr[pivotIndex]) leftMost++;
			while (start < rightMost && arr[rightMost] >= arr[pivotIndex]) rightMost--;
			
			if (leftMost < rightMost) { 
				swap(arr, leftMost, rightMost);
			}else {
				break;
			}
		}
		
		// swap at the end
		// Depends on the starting pivot, this may be swap(arr, pivotIndex, leftMost)
		swap(arr,pivotIndex, rightMost);
		return rightMost;
	
	}
    private void swap(int[] arr, int left, int right) {
    	int t = arr[left];
    	arr[left] = arr[right];
    	arr[right] = t;
    }
    
    public static void main(String[] args) {
    	WiggleSort x = new WiggleSort();
    	int[] arr = {2,1,1,2,1,3,3,3,1,3,1,3,2};
    	x.wiggleSort(arr);
    	for(Integer a : arr) {
    		System.out.print(a + ",");
    	}
	}
}
