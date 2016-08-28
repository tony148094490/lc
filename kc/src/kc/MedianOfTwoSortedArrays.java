package kc;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	
        int l = (nums1.length + nums2.length + 1) / 2;
        int r = (nums1.length + nums2.length + 2) / 2;
        
        int first = getKthNumber(nums1, 0, nums2, 0, l);
        int second = getKthNumber(nums1, 0, nums2, 0, r);
        
        return (first + second) / 2.0;
    }
    
    private int getKthNumber(int[] a, int aStart, int[] b, int bStart, int k) {
    	if(aStart >= a.length) return b[bStart + k - 1];
    	if(bStart >= b.length) return a[aStart + k - 1];
    	
    	if(k == 1) return Math.min(a[aStart], b[bStart]);
    	
    	int nr = k / 2 ;// number of elements to be removed from each array safely.
    	
    	if(aStart + nr - 1 >= a.length) {
    		return getKthNumber(a, aStart, b, bStart + nr,k -  k / 2);
    	} else if (bStart + nr - 1 >= b.length) {
    		return getKthNumber(a, aStart + nr, b, bStart, k - k / 2);
    	} else {
    		if(a[aStart + nr - 1] > b[bStart + nr - 1]) {
    			return getKthNumber(a, aStart, b, bStart + nr ,k -  k / 2);
    		} else {
    			return getKthNumber(a, aStart + nr, b, bStart, k - k / 2);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	MedianOfTwoSortedArrays x = new MedianOfTwoSortedArrays();
    	int[] a = {3,4};
    	int[] b = {};
    	System.out.println(x.findMedianSortedArrays(a, b));
	}
}
