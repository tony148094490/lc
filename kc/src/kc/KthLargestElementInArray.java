package kc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
	public int findKthLargest(int[] nums, int k) {
    	
    	Comparator<Integer> comp = new Comparator<Integer>(){
    		public int compare(Integer a, Integer b) {
    			if(a > b) {
    				return -1;
    			} else if(a < b) {
    				return 1;
    			} else{
    				return 0;
    			}
    		}
    	};
    	
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, comp);
        
        for(Integer x : nums){
        	heap.offer(x);
        }
        
        while(k>1) {
        	heap.poll();
        	k--;
        }
        
        return heap.poll();
    }


    public int findKthLargest2(int[] nums, int k) {
        int i = quickSort(nums, 0, nums.length-1, k);
        return nums[i];
    }
    
    private int quickSort(int[] nums, int left, int right, int k) {
        if(left == right) return left;
        int sorted = pivot(nums, left, right);
        if(sorted == k - 1) return sorted;
        if(sorted > k - 1) {
            return quickSort(nums, left, sorted-1, k);
        } else {
            return quickSort(nums, sorted + 1, right, k);
        }
    }
    
    private int pivot(int[] nums, int start, int end) {
        int piv = nums[start];
        int left = start;
        int right = end;
        while(left <= right) {
            while(left <= right && nums[left] >= piv) left++;
            while(left <= right && nums[right] <= piv) right--;
            if(left <= right) {
                swap(nums,left, right);
                left++;
                right--;
            }
        }
        swap(nums, start, right);
        return right;
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
	
	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4,2,2,2,2,2,2,2};
		KthLargestElementInArray x = new KthLargestElementInArray();
		System.out.println(x.findKthLargest2(arr, 2));
	}

}
