package kc;

import java.util.Arrays;

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
    
    private void swap(int[] arr, int l , int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
