package kc;

public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        
        for(int i = Math.max(0, k - n); i <= m && i <= k ; i++) {
        	int[] localMax = merge(getMax(nums1, i), getMax(nums2, k-i), k);
        	if(greaterOrEqualTo(localMax, 0, res, 0)) {
        		res = localMax;
        	}
        }
        return res;
    }
    
    private int[] merge(int[] arr1, int[] arr2, int k) {
    	int[] res = new int[k];
    	int i = 0;
    	int j = 0;
    	int m = 0;
    	while(m < k) {
    		if(greaterOrEqualTo(arr1, i, arr2, j)) {
    			res[m] = arr1[i];
    			i++;
    		} else {
    			res[m] = arr2[j];
    			j++;
    		}
    		m++;
    	}
    	
    	return res;
    }
    
    private boolean greaterOrEqualTo(int[] arr1, int i, int[] arr2, int j) {
    	while(i < arr1.length && j < arr2.length && arr1[i] == arr2[j]) {
    		i++;
    		j++;
    	}
    	if(i == arr1.length && j == arr2.length) {
    		return true;
    	} else if(j == arr2.length) {
    		return true;
    	} else if(i == arr1.length) {
    		return false;
    	} else if(arr1[i] >= arr2[j]) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    private int[] getMax(int[] arr, int k) {
    	int n = arr.length;
    	int[] res = new int[k];
    
    	int last = -1;
    	for(int i = 0; i < k ; i++) {
    		for(int j = last + 1; j + (k - i - 1) < n; j++) {
    			if(res[i] < arr[j]) {
    				res[i] = arr[j];
    				last = j;
    			}
    		}
    	}
    	
    	return res;
    }
      
    public static void main(String[] args) {
    	CreateMaximumNumber x = new CreateMaximumNumber();
    	int[] arr = {3, 4, 6, 5};
    	int[] arr2 = {9, 1, 2, 5, 8, 3};
    	for(Integer a : x.maxNumber(arr, arr2, 10)) {
    		System.out.print(a + ",");
    	}
 
    }
}
