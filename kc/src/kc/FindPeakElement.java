package kc;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0) return 0;
        return find(nums, 0, nums.length-1);
    }
    private int find(int[] nums, int l, int r) {
        if(l == r) return l;
        if(l + 1 == r) {
            if(nums[l] < nums[r]) return r;
            return l;
        }
        if(l + 2 == r) {
            if(nums[l] <= nums[r] && nums[l+1] < nums[r]) return r;
            if(nums[l] > nums[l+1] && nums[l] >= nums[r]) return l;
            return l+1;
        }
        int m = l + (r - l) / 2;
        if(nums[m] < nums[l] ) {
            return find(nums, l, m);
        } else if(nums[m] < nums[r]) {
            return find(nums, m, r);
        } else {
            if(nums[m] > nums[m-1]) {
                return find(nums, m, r);
            } else {
                return find(nums, l, m-1);
            }
        }
    }
    
    
    public static void main(String[] args) {
		FindPeakElement x = new FindPeakElement();
		int[] arr = {3,5,6,5,6,4,3};
		System.out.println(x.findPeakElement(arr));
	}
}
