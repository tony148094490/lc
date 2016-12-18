package kc;

public class HorseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);
        
        int first = nums[0];
        int second = nums[1];
        int third = Math.max(nums[0] + nums[2], nums[1]);
        
        int res = 0;
        for(int i = 3; i < nums.length;i++){
            res = Math.max(nums[i] + Math.max(first, second), third);
            first = second;
            second = third;
            third = res;
        }
        return res;
    }
    
    public static void main(String[] args) {
		int[] arr = {2,1,5,9};
		HorseRobber x = new HorseRobber();
		System.out.println(x.rob(arr));
	}
}
