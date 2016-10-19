package kc;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if(nums.length < 2) return -1;
        int slow = nums[0];
        int fast = nums[slow];
        while(slow != fast) {
        	slow = nums[slow];
        	fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast) {
        	slow = nums[slow];
        	fast = nums[fast];
        }
        return slow;
    }
}
