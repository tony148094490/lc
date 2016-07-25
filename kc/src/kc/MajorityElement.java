package kc;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return 0;
        int counter = 1;
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == res) {
                counter++;
            } else {
                counter--;
                if(counter < 0) {
                    counter = 1;
                    res = nums[i];
                }
            }
        }

    
        return res;
    }
}
