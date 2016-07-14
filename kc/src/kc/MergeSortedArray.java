package kc;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
    	int i = nums1.length - 1;
    	for(i = nums1.length - 1 ; i >= 0 && m >0 && n >0 ; i--) {
    		
        	if(nums1[m-1] >= nums2[n-1]) {
        		nums1[i] = nums1[m-1];
        		m--;
        	} else {
        		nums1[i] = nums2[n-1];
        		n--;
        	}
        }
        
        if(n>0) {
        	while(i>=0) {
        		nums1[i] = nums2[n-1];
        		n--;
        		i--;
        	}
        }
    }
    
    public static void main(String[] args) {
    	int[] a = {1,3,5,7,9,0,0,0};
    	int[] b = {2,4,6};
    	MergeSortedArray x = new MergeSortedArray();
    	x.merge(a, 5, b, 3);
    	for(Integer c : a) System.out.print(c);
    	
    }
}
