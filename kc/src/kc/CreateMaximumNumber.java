package kc;

/**
 * The algo goes like this:
 * get x nr of digits from left and (k - x) nr of digits from right
 * merge them together and compare it with the local maximum
 * when merging, needs to do make sure the merged result is largest because the 
 * two sub arrays might not be sorted, need to tie break in case of equal values
 * then get the result
 * when comparing, always use lexicographical order
 */
public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for(int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] left = getMax(nums1, i);
            int[] right = getMax(nums2, k - i);
            int[] merged = merge(left, right);
            if(greaterOrEqual(merged, 0, res, 0)) {
                res = merged;
            }
        }
        return res;
    }
    
    private int[] merge(int[] A, int[] B) {
        int[] res = new int[A.length + B.length];
        int m = 0;
        int n = 0;
        for(int i = 0 ; i < res.length; i++) {
            if(greaterOrEqual(A, m, B, n)) {
                res[i] = A[m];
                m++;
            } else {
                res[i] = B[n];
                n++;
            }
        }
        return res;
    }
    
    private boolean greaterOrEqual(int[] A, int i, int[] B, int j) {
        while(i < A.length && j < B.length && A[i] == B[j]) {
            i++;
            j++;
        }
        if(i == A.length && j == B.length) return true;
        if(i == A.length) return false;
        if(j == B.length) return true;
        if(A[i] > B[j]) return true;
        return false;
    }
    
    private int[] getMax(int[] arr, int k) {
        int[] res = new int[k];
        int lastIndex = -1;
        for(int i = 0 ; i < res.length; i++) {
            for(int j = lastIndex + 1; j <= arr.length - (k - i); j++) {
                if(arr[j] > res[i]) {
                    res[i] = arr[j];
                    lastIndex = j;
                }
            }
        }
        return res;
    }
      
    public static void main(String[] args) {
    	CreateMaximumNumber x = new CreateMaximumNumber();
//    	int[] arr = {6,7};
//    	int[] arr2 = {6,0,4};
//    	for(Integer a : x.maxNumber(arr, arr2, 5)) {
//    		System.out.print(a + ",");
//    	}
    	int[] arr = {3,1};
    	int[] arr2 = {3};
    	int[] res = x.merge(arr, arr2);
    	for(int a : res) System.out.println(a);
    }
}
