package kc;

import java.util.Arrays;

public class TiangleNumber {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0 ; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++) {
                int left = j;
                int right = nums.length-1;
                int target = nums[i] + nums[j];
                if(target > nums[nums.length-1]) {
                    //res += (nums.length - j - 1);
                    res += (nums.length - j) * (nums.length - j - 1)/ 2;
                    break;
                }
                int b = bs(nums,left, right, target);
                
                while(b > j && nums[b] >= target) b--;
                b++;
                
                if(b > j + 1 ) {
                    res += (b - j - 1);
                }
            }
        }
        return res;
    }
    
    private int bs(int[] nums, int l, int r, int target) {
        if(l >= r) return l;
        int m = l + (r - l) / 2;
        if(nums[m] == target) {
            return m;
        } else if(nums[m] < target) {
            return bs(nums, m+1,r,target);
        } else {
            return bs(nums,l,m-1,target);
        }
    }
    public static void main(String[] args) {
		TiangleNumber s = new TiangleNumber();
		int[] arr = {24,3,82,22,35,84,19};
		Arrays.sort(arr);
		for(int x : arr) System.out.print(x + ",");
		System.out.println();
		System.out.println(s.triangleNumber(arr));
	}
}
