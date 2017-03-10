package kc;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if(nums.length < 2) return -1;
        int slow = 0;
        int fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                fast = 0;
                while(slow != fast) {
                  slow = nums[slow];
                  fast = nums[fast];
                }
                return slow;
            }
        }
    }
    // another solution is to use search the whole space with binary search one by one 
}
