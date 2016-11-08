package kc;

import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length == 0) return true;
        Stack<Integer> stack = new Stack<Integer>();
        int min = Integer.MIN_VALUE;
        stack.push(preorder[0]);
        for(int i = 1 ; i < preorder.length; i++) {
            if(preorder[i] < min) return false;
                if(preorder[i] < stack.peek()) {
                    stack.push(preorder[i]);
                } else {
                    int last = stack.peek();
                    while(!stack.isEmpty() && stack.peek() < preorder[i]) {
                        last = stack.pop();
                    } 
                    min = last;
                    stack.push(preorder[i]);
                }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	int[] arr = {5,10,2,1,4,3,9,8,6,7,11,12};
    	VerifyPreorderSequenceInBinarySearchTree x = new VerifyPreorderSequenceInBinarySearchTree();
    	System.out.println(x.verifyPreorder(arr));
    }
}
