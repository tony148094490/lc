package kc;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2 ; i < nums.length-1;i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        
        int a = dp[nums.length-2];
        
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for(int i = 3 ; i < nums.length;i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        
        int b = dp[nums.length-1];
        
        return Math.max(a,b);
    }
    
    
    public int rob2(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(nums[2], Math.max(nums[0], nums[1]));
        // four cases: 1) first is chosen and last is chosen (max one wins) 2/3) first or last is chosen(chosen one wins) 4) neither is chosen (max are same)
        int[] potentialFirst = new int[nums.length-1];
        int[] potentialLast = new int[nums.length-1];
        potentialFirst[0] = nums[0];
        potentialFirst[1] = Math.max(nums[0], nums[1]);
        potentialLast[0] = nums[1];
        potentialLast[1] = Math.max(nums[1], nums[2]);
        for(int i = 2 ; i < nums.length - 1; i++) {
            potentialFirst[i] = Math.max(potentialFirst[i-1], potentialFirst[i-2] + nums[i]);
            potentialLast[i] = Math.max(potentialLast[i-1], potentialLast[i-2] + nums[i+1]);
        }

        return Math.max(potentialLast[nums.length-2], potentialFirst[nums.length-2]);
    }
    
    public static void main(String[] args) {
		HouseRobberII x = new HouseRobberII();
		int[] arr = {2,1,1,1};
		System.out.println(x.rob2(arr));
	}
    
}
