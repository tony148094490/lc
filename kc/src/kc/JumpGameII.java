package kc;
/**
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
For example:
Given array nums = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
Note:
You can assume that you can always reach the last index.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int maxReachability = nums[0];
        int res = 0;
        int curReachability = 0;
        for(int i = 1 ; i < nums.length; i++) {
        	if(curReachability < i) {
        		res++;
        		curReachability = maxReachability;
        	}
        	
        	maxReachability = Math.max(maxReachability, nums[i] + i);
        	
        }
        return res;
    }
    public static void main(String[] args) {
    	JumpGameII x = new JumpGameII();
    	int[] A = {2,3,1,1,4};
    	System.out.println(x.jump(A));
	}
}
