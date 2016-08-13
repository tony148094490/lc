package kc;

public class IncreasingTripletSequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int first = nums[0];
        int second = nums[0];
        int i = 1;
        for(i = 1; i < nums.length; i++) {
        	if(nums[i] > first) 
        		{
        			second = nums[i];
        			break;
        		}
        	if(nums[i] < first) {
        		first = nums[i];
        		second = nums[i];
        	}
        }
        
        if(i == nums.length) return false;
        int potential = first;
        for(int j = i + 1 ; j < nums.length; j++) {
        	if(nums[j] > second) {
        		return true;
        	} else if(nums[j] > potential) {
        		second = nums[j];
        		first = potential;
        	} else if (nums[j] < potential) {
        		potential = nums[j];
        	}
        }
        return false;
        
    }
    
    
}
