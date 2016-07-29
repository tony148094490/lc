package kc;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;    
        int left = 0;
        int sum = 0;
        int size = 0;
        if(nums[0] >= s) return 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= s) return 1;
            if(sum + nums[i] >= s) {
                while(sum + nums[i] >=s) {
                    if(size != 0){
                        size = Math.min(size, i - left);
                    } else {
                        size = i - left;
                    }
                    sum -= nums[left];
                    left++;
                }
                sum += nums[i];
            } else {
                sum += nums[i];
            }
        }
        return  size == 0 ? 0 : size + 1;
    }
    public static void main(String[] args) {
		MinimumSizeSubarraySum x = new MinimumSizeSubarraySum();
		int[] arr = {2,3,1,2,4,3};
		System.out.println(x.minSubArrayLen(7, arr));
	}
}
