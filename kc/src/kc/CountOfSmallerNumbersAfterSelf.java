package kc;

import java.util.ArrayList;
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
        if(nums.length == 0) return new ArrayList<Integer>();
        Integer[] arr = new Integer[nums.length];
        Node root = null;
        for(int i = nums.length-1 ; i >= 0 ; i--) {
            root = insert(arr, i, nums[i], 0, root);
        } 
        return Arrays.asList(arr);
    }
    
    private Node insert(Integer[] res, int index, int val, int leftSum, Node root) {
        if(root == null) {
            root = new Node(val, 0);
            res[index] = leftSum;
        } else if(root.val == val) {
            root.dup++;
            res[index] = root.leftSum + leftSum;
        } else if(root.val > val) {
            root.leftSum++;
            root.left = insert(res, index, val, leftSum, root.left);
        } else {
            root.right = insert(res, index, val, root.leftSum + leftSum + root.dup, root.right);
        }
        
        return root;
    }
    
    class Node {
        Node left;
        Node right;
        int val;
        int dup;
        int leftSum;
        Node(int val, int leftSum) {
            this.val = val;
            this.leftSum = leftSum;
            dup = 1;
        }
    }
    
    public static void main(String[] args) {
    	CountOfSmallerNumbersAfterSelf x = new CountOfSmallerNumbersAfterSelf();
    	int[] arr = {5,2,6,6,1};
    	System.out.println(x.countSmaller(arr));
    }
}
