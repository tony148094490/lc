package kc;
/**
ok, i'm going try explaining this while my memory is fresh, first of all, you wrote this, not people online.
so the general idea is that we do a merge sort against the range sums, fix the sums on the left hand side,
and iterate through right hand side. since the question is asking for count of range sums, the numbers on 
right hand side will always appear after left hand side. while iterating, we do a subtraction of left hand side
from right hand side, what it means is that we want to examine if the result, a range from end of left hand side to
the end of right hand side is within the boundary. since left hand side and right hand side are both sorted, we keep
two pointers, lo and hi, so when sums[lo] - sums[current] >= min and sums[hi] - sums[current], we will know the diff
between hi and lo is the number of ranges we have when we don't use sums[current] (some portion of the array)
we then do this for the rest of the sums on the left hand side while iterating the right hand side.

we allocated a helper array for reducing the time when we do the actual merging, this array should be optional and 
won't affect the overall time complexity.

a tricky part is the additional 0 placed at the initial point, this is true for most of the range sums processing problems
  
 */
public class CountOfRangeSum {
    int min;
    int max;
    int count;
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length == 0) return 0;
        min = lower;
        max = upper;
        count = 0;
        long[] temp = new long[nums.length + 1];
        long[] sums = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + (long) nums[i];
        }
        
        mergeSort(sums, temp, 0, sums.length-1);
        return count;
    }
    
    private void mergeSort(long[] arr, long[] temp, int start, int end) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, temp, start, mid);
        mergeSort(arr, temp, mid + 1, end);
        merge(arr, temp, start, mid, end);
    }
    
    private void merge(long[] arr, long[] temp, int start, int mid, int end) {

        // for merging
        int index = start;
        int hiStart = mid+1;
        
        // high low bounds for evaluating candidates, it's very important to set them the scope as is
    	int lo = mid + 1;
        int hi = mid + 1;
        
        for(int i = start; i <= mid; i++) {
	
        	// examine candidates
            while(lo <= end && arr[lo] - arr[i] < min) lo++;
            while(hi <= end && arr[hi] - arr[i] <= max) hi++;
            count += (hi - lo);
            
            // merging
            while(hiStart <= end && arr[hiStart] < arr[i]) {
                temp[index] = arr[hiStart];
                hiStart++;
                index++;
            }
            temp[index] = arr[i];
            index++;
        }
        
        for(int i = start ; i < index; i++) {
            arr[i] = temp[i];
        }
        
    }
    
    
    public static void main(String[] args) {
     int[] arr = {-2, 1};
     CountOfRangeSum x = new CountOfRangeSum();
     System.out.println(x.countRangeSum(arr, -2, 2));
    }
}
