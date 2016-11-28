package kc;

import java.util.LinkedList;

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        if(a == 0) {
        	if(b >=0) {
        		for(int i = 0 ; i < nums.length; i++) {
        			res[i] = nums[i] * b + c;
        		}
        	} else {
        		for(int i = nums.length -1 ; i >= 0; i--) {
        			res[nums.length - 1 - i] = nums[i] * b + c;
        		}
        	}
        	return res;
        }
        
    	//get maximum or minimum of the function
    	double x = (-1 * (double) b) / ((double) a * 2);
    	System.out.println(x);
    	//split to two halves 
    	LinkedList<Integer> left = new LinkedList<Integer>();
    	LinkedList<Integer> right = new LinkedList<Integer>();
    	if(a > 0) {
    		int i = 0;
    		while(i < nums.length && nums[i] < x) {
    			left.addFirst(nums[i] * nums[i] * a + nums[i] * b + c);
    			i++;
    		}
    		while(i < nums.length && nums[i] >= x) {
    			right.add(nums[i] * nums[i] * a + nums[i] * b + c);
    			i++;
    		}
    	} else {
    		int i = 0;
    		while(i < nums.length && nums[i] < x) {
    			left.add(nums[i] * nums[i] * a + nums[i] * b + c);
    			i++;
    		}
    		while(i < nums.length && nums[i] >= x) {
    			right.addFirst(nums[i] * nums[i] * a + nums[i] * b + c);
    			i++;
    		}
    	}
    	System.out.println(left);
    	System.out.println(right);
    	//merge
    	int index = 0;
    	int leftIndex = 0;
    	int rightIndex = 0;
    	while(leftIndex < left.size() && rightIndex < right.size()) {
    		if(left.get(leftIndex) < right.get(rightIndex)) {
    			res[index] = left.get(leftIndex);
    			leftIndex++;
    		} else {
    			res[index] = right.get(rightIndex);
    			rightIndex++;
    		}
    		index++;
    	}
    	if(leftIndex == left.size()) {
    		while(rightIndex < right.size()) {
    			res[index] = right.get(rightIndex);
    			rightIndex++;
    			index++;
    		}
    	} else {
    		while(leftIndex < left.size()) {
    			res[index] = left.get(leftIndex);
    			leftIndex++;
    			index++;
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	int[] nums = {-99,-94,-90,-88,-84,-83,-79,-68,-58,-52,-52,-50,-47,-45,-35,-29,-5,-1,
    	    	 9,12,13,25,27,33,36,38,40,46,47,49,57,57,61,63,73,75,79,97,98};
    	int a = -2, b = 44, c = -56;
    	SortTransformedArray x = new SortTransformedArray();
    	int[] res = x.sortTransformedArray(nums, a, b, c);
    	for(int r : res) System.out.print(r + ",");
	}
}
