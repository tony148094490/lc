package kc;

import java.util.Arrays;
import java.util.List;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int median = getK(copy, copy.length % 2 == 0 ? copy.length / 2 - 1: copy.length/2, 0, copy.length-1);

        int leftEnd = median;
        int i = 0;
        while( i < leftEnd) {
            while(i < leftEnd && copy[leftEnd] == copy[median]) leftEnd--;
            while(i < leftEnd && copy[i] < copy[median]) i++;
            if(i < leftEnd) swap(copy, i, leftEnd);
        }
        
        int rightEnd = copy.length-1;
        int j = median+1;
        while( j < rightEnd) {
            while( j < rightEnd && copy[rightEnd] > copy[median]) rightEnd--;
            while( j < rightEnd && copy[j] == copy[median]) j++;
            if(j < rightEnd) swap(copy, j, rightEnd);
        }
        
        i = 0;
        for(int sm = median,bg = nums.length-1; i <= copy.length-2 && sm>=0 && bg>=0; i+=2, sm--, bg--) {
            nums[i] = copy[sm];
            nums[i+1] = copy[bg];
        }
        
        if(nums.length % 2 != 0) {
            nums[nums.length-1] = copy[0];
        }
    }
    
    // quick sort
    private int getK(int[] arr, int k, int l, int r) {
        if(l == r) return l;
        int sorted = partition(arr, l, l + 1, r);
        if(sorted == k) return k;
        if(sorted > k) {
            return getK(arr, k, l, sorted - 1);
        } else {
            return getK(arr, k, sorted + 1 , r);
        }
    }
    
    private int partition(int[] arr, int pivot, int left, int right) {
        int start = pivot;
        int end = right;
        
        while(true) {
            while(left < end && arr[left] <= arr[pivot]) left++;
            while(right >start && arr[right] >= arr[pivot]) right--;
            if(left < right) {
                swap(arr, left, right);
            } else {
                break;
            }
        }
        swap(arr, pivot, right);
        return right;
    }
    private int partition(int[] nums, int lo, int hi) {
        if( hi == lo ) return hi;
        int pivot = lo;
        int start = lo + 1;
        int end = hi;
        while(start < end) {
            while(start < hi && nums[start] <= nums[pivot]) start++;
            while(end > lo && nums[end] >= nums[pivot]) end--;
            if(start < end) swap(nums, start, end);
        }

        swap(nums, pivot, end);
        return end;
    }
    private void swap(int[] arr, int l , int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    
    
    public void wiggleSort2(int[] nums) {
        int median = getK2(nums, nums.length % 2 == 0 ? nums.length / 2 - 1: nums.length/2, 0, nums.length-1);

        // there could be a better way
        int[] copy = Arrays.copyOf(nums, nums.length);
        
        int i = 0;
        for(int sm = median,bg = nums.length-1; i <= copy.length-2 && sm>=0 && bg>=0; i+=2, sm--, bg--) {
            nums[i] = copy[sm];
            nums[i+1] = copy[bg];
        }
        
        if(nums.length % 2 != 0) {
            nums[nums.length-1] = copy[0];
        }
    }
    
    private int getK2(int[] arr, int k, int l, int r) {
        if(l == r) return l;
        int[]  sorted = threeWayPartitionForGetK(arr, l, r);
    
    	
        if(k >= sorted[0] && k <= sorted[1]) {

        	return k;
        }
        if(sorted[0] > k) {
            return getK2(arr, k, l, sorted[0] - 1);
        } else {
            return getK2(arr, k, sorted[1] + 1 , r);
        }
    }
    
    private int[] threeWayPartitionForGetK(int[] arr, int lo, int hi) {
    	
    	if(lo >= hi) return new int[] {hi, lo};
    	
    	int lt = lo, i = lo + 1, gt = hi;
    	int pivot = arr[lo];
    	
    	while(i <= gt) {
    		int comp = arr[i] - pivot;
    		if(comp < 0) swap(arr, lt++, i++);
    		else if(comp > 0) swap(arr, i, gt--);
    		else i++;
    	}
    	
    	return new int[] {lt, gt};
    }
    
    public void wiggleSort1(int[] nums) {
        if(nums.length < 2) return;
        boolean up = false;
        int index = 1;
        while(index < nums.length) {
            if(up && nums[index] > nums[index-1]) {
                swap(nums, index, index-1);
            } else if(!up && nums[index] < nums[index-1]) {
                swap(nums, index, index-1);
            }
            up = !up;
            index++;
        }
    }
    
    public static void main(String[] args) {
    	int[] res = {1,2};
    	WiggleSort x = new WiggleSort();
    	System.out.println(x.partition(res, 0, 1));
    	for(int a : res) System.out.println(a);
    }
}
