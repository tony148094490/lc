package kc;

public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length <= 1) return true;
        Integer[][] maxDiff = new Integer[nums.length][nums.length];
        return getMaxDiff(nums, 0, nums.length - 1, maxDiff) >= 0;
    }
    
    private int getMaxDiff(int[] nums, int left, int right, Integer[][] maxDiff) {
        if(maxDiff[left][right] == null) {
            if(left == right) {
                maxDiff[left][right] = nums[left];
            } else {
                maxDiff[left][right] = Math.max(nums[left] - getMaxDiff(nums,left+1, right, maxDiff), nums[right] - getMaxDiff(nums, left, right-1, maxDiff));
            }
        }
        return maxDiff[left][right];
    }
}
