package kc;

public class WiggleSortI {
    public void wiggleSort(int[] nums) {
        boolean goingUp = true;
        for(int i = 0 ; i < nums.length - 1; i++) {
            if(goingUp) {
                if(nums[i] > nums[i+1]) {
                    swap(i, i+1, nums);
                }
                goingUp = false;
            } else {
                if(nums[i] < nums[i+1]) {
                    swap(i, i+1, nums);
                }
                goingUp = true;
            }
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
