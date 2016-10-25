package kc;
/**
 This question is very hard and it took me a long time to fully think through the answer.
 First, the easy solution is to create a prefix array and do a two-sum like thing to enumerate all the combinations.
 Each combination is a count. It's n(n-1)/2 complexity.
 
 Then a better solution is to do this sort of enumeration during a merge sort to save time because we can get nlogn.
 The idea is actually quite simple albeit it's the first time i've seen a different kind of merging method.
 While we are merging from second sorted array to first sorted array, we also see if there is are cases
 in the second sorted array where some values minus the current visiting first sorted array's value are within our range
 if there are, we note them down. Otherwise, we continue merging. 
 
 Essentially, when we have two sorted arrays, first and second. We do two things, first is the actual (novel) merging algorithm:
 fix one index in the first array, iterate through the second array and output the number which is smaller than the one in first array,
 then do the next index in the first array until we visit all the elements in first array, then copy the rest from second array to result.
 The second thing we do is that we also fix one index in the first array, we look for candidates in second array where 
 the number in second array minus this number in first array is within our range. If it is, it's a hit and we record it.
 Because two things all start with fixing one element from the first sorted array and iterate through the second array, we can combine
 them together and save time while leverage the property that we don't have to visit any elements in the first array while fixing an
 element in the first array because we have already done that in the previous round of merging.
  
 */
public class CountOfRangeSum {
    int count = 0;
    int lower;
    int upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        long[] temp = new long[nums.length + 1];
        sum[0] = 0;
        this.lower = lower;
        this.upper = upper;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + (long) nums[i - 1];
        }
        
        mergesort(sum, 0, sum.length - 1, temp);
        return count;
    }
    
    private void mergesort(long[] sum, int start, int end, long[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergesort(sum, start, mid, temp);
        mergesort(sum, mid + 1, end, temp);
        merge(sum, start, mid, end, temp);
    }
    
    private void merge(long[] sum, int start, int mid, int end, long[] temp) {
        int right = mid + 1;
        int index = start;
        int low = mid + 1, high = mid + 1;
        for (int left = start; left <= mid; left++) {
            // actually merging, part one
            while (right <= end && sum[right] < sum[left]) {
                temp[index++] = sum[right++];
            }
            temp[index++] = sum[left];
            
            // for the purpose of counting, we need to have another 'ordered' array to be able to count indices 
            while (low <= end && sum[low] - sum[left] < lower) {
                low++;
            }
            while (high <= end && sum[high] - sum[left] <= upper) {
                high++;
            }
            count += high - low;
            // counting part ends
        }
        
        // another part for merging
        while (right <= end) {
            temp[index++] = sum[right++];
        }
        
        // overwrite the original array
        for (int i = start; i <= end; i++) {
            sum[i] = temp[i];
        }
    }
}
