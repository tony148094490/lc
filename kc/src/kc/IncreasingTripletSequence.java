package kc;
// idea is that we keep first two in place, when encountered a value that's lower or equal to a, 
// buffer it and wait until one that's greater than the buffered value then we replace a and b.
// otherwise we can manipulate a, b if needed.
public class IncreasingTripletSequence {
    public boolean increasingTriplet(int[] nums) {
        Integer a = null, b = null, buffer = null;

        for(int i = 0 ; i < nums.length; i++) {
            if(a == null) {
                a = nums[i];
                buffer = nums[i];//tricky
            } else if(b == null) {
                if(a >= nums[i]) {
                    a = nums[i];
                    buffer = nums[i];//tricky
                } else {
                    b = nums[i];
                }
            } else {
                if(nums[i] > b) {
                    return true;
                } else if(nums[i] > a) {
                    b = nums[i];
                } else {
                    if(nums[i] > buffer) {
                        a = buffer;
                        b = nums[i];
                        buffer = a;
                    } else {
                        buffer = nums[i];
                    }
                }
            }
        }
        return false;
    }
    
    
}
