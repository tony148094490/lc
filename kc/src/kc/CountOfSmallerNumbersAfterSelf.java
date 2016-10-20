package kc;

import java.util.Arrays;
import java.util.List;

/**
You are given an integer array nums and you have to return a new counts array. 
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Return the array [2, 1, 1, 0]. 
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
       Integer[] res = new Integer[nums.length];
       
       BT root = null;
       for(int i = nums.length-1; i >= 0 ; i++) {
    	   root = insert(res,i, 0, nums[i], root);
       }
       return Arrays.asList(res);
    }
    
    private BT insert(Integer[] res, int index, int curLeftSum, int target, BT curNode) {
    	if(curNode == null) {
    		curNode = new BT(target, 0);
    		res[index] = curLeftSum;
    	} else if(curNode.value == target) {
    		curNode.dup++;
    		res[index] = curLeftSum + curNode.leftSum;
    	} else if(curNode.value > target) {
    		curNode.leftSum++;
    		curNode.left = insert(res, index, curLeftSum, target, curNode.left);
    	} else {
    		curNode.right = insert(res, index, curLeftSum + curNode.leftSum + curNode.dup, target, curNode.right);
    	}
    	return curNode;
    }
    
    private class BT {
    	BT left;
    	BT right;
    	int value;
    	int leftSum;
    	int dup = 1;
    	BT(int i, int leftSum) {
    		value = i;
    		this.leftSum = leftSum;
    	}
    }
}
