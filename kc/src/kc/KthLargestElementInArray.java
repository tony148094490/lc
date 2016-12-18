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
		if(nums.length == 0 || k > nums.length) return -1;
		int l = 0;
		int h = nums.length-1;
		int pivot = sort(nums, l+1, h, l);
		while(pivot != k - 1) {
			if(pivot > k -1) {
				h = pivot-1;
				pivot = sort(nums, l+1, h, l);
			} else {
				l = pivot+1;
				pivot = sort(nums, l+1, h,l);
			}
		}
		return nums[pivot];
	}
	
	private int sort(int[] nums, int i, int j, int pivot) {
		int left = i;
		int right = j;
		while(left < right) {
			while(left < right && nums[left] > nums[pivot]) left++;
			while(left < right && nums[right] <= nums[pivot]) right--;
			if(left < right) {
				swap(nums, left, right);
				left++;
				right--;
			} else {
				break;
			}
		}
		
		if(left == right) {
			if(nums[left] > nums[pivot]) {
				swap(nums,pivot,left);
				return left;
			} else {
				swap(nums, pivot, left-1);
				return left-1;
			}
		} else {
			swap(nums, pivot, right);
			return right;
		}
	}
	
	private void swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4,2,2,2,2,2,2,2};
		KthLargestElementInArray x = new KthLargestElementInArray();
		System.out.println(x.findKthLargest2(arr, 2));
	}

}
