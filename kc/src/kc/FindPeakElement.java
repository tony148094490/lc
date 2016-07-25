package kc;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
    	return findPeakElement(nums,0,nums.length-1);
    }
    
    private int findPeakElement(int[] nums, int l, int r) {
    	if(l == r) return l;
    	if(l + 1 == r) {
    		if(nums[l] < nums[r]) {
    			return r;
    		} else {
    			return l;
    		}
    	}
    	
    	if(l + 2 == r) {
    		if(nums[l] < nums[r]) {
    			if(nums[l+1] < nums[r]) {
    				return r;
    			} else {
    				return l+1;
    			}
    		} else {
    			if(nums[l+1] < nums[l]) {
    				return l;
    			} else {
    				return l+1;
    			}
    		}
    	}
    	
    	int m = (l+r)/2;
    	
    	if(nums[m] < nums[l]) {
    		return findPeakElement(nums,l,m);
    	} else if(nums[m] < nums[r]) {
    		return findPeakElement(nums,m,r);
    	} else {
    		if(nums[m-1] > nums[m]) {
    			return findPeakElement(nums,l,m-1);
    		} else {
    			return findPeakElement(nums,m,r);
    		}
    	}
    	
    }
    
    
    public static void main(String[] args) {
		FindPeakElement x = new FindPeakElement();
		int[] arr = {3,5,6,5,6,4,3};
		System.out.println(x.findPeakElement(arr));
	}
}
