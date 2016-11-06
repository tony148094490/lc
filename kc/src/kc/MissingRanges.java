package kc;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    	List<String> res = new ArrayList<String>();
    	
    	if(nums.length == 0) {
    		String cur = "";
    		if(lower == upper) {
    			cur += lower;
    		} else {
    			cur += lower + "->" + upper;
    		}
    		res.add(cur);
    		return res;
    	}
    	
    	
    	if(nums[0] > lower) {
        	String cur = "";
    		cur += lower;
    		if(nums[0] > lower + 1) {
    			cur += "->" + (nums[0] - 1);
    		}
    		res.add(cur);
    	} 
    	
    	for(int i = 1 ; i < nums.length; i++) {
    		if(nums[i] > nums[i-1] + 1) {
    			String newCur = "";
    			newCur += (nums[i-1] + 1);
    			if(nums[i] > nums[i-1] + 2) {
    				newCur += "->" + (nums[i] - 1);
    			}
    			res.add(newCur);
    		}
    	}
    	
    	if(upper > nums[nums.length-1]) {
    		String newCur = "";
    		newCur += nums[nums.length-1] + 1;
    		if(upper > nums[nums.length-1] + 1) {
    			newCur += "->" + upper;
    		}
    		res.add(newCur);
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	MissingRanges x = new MissingRanges();
    	int[] arr = {0, 1, 3, 50, 75};
    	System.out.println(x.findMissingRanges(arr, 0,99));
    }
}
