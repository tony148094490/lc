package kc;

import java.util.Stack;


public class VerifyPreOrderSerializationOfBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 0) return false;
        String[] strs = preorder.split(",");
        if(helper(strs, 0) != strs.length) return false;
        return true;
    }
    // idea is to get the size of tree
    private int helper(String[] arr, int index) {
        if(index >= arr.length) return -1;
        if(arr[index].equals("#")) return 1;
        int leftSize = helper(arr, index + 1);
        if(leftSize == -1) return -1;
        int rightSize = helper(arr, index + leftSize + 1);
        if(rightSize == -1) return -1;
        return leftSize + rightSize + 1;
    }
    
    
    // idea is to pop nulls and numbers and add one back for later pop
    public boolean isValidSerialization2(String preorder) {
        if(preorder.length() == 0) return false;
        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        for(int i = 0 ; i < strs.length; i++) {
            if(strs[i].equals("#")) {
                if(!stack.isEmpty() && stack.peek().equals("#")) {
                    while(!stack.isEmpty() && stack.peek().equals("#")) {
                        stack.pop();
                        if(stack.isEmpty()) return false;
                        stack.pop();
                    }
                }
                stack.push("#");
            } else {
                stack.push(strs[i]);
            }
        }
        
        return stack.size() == 1 && stack.peek().equals("#");
    }
    
    public static void main(String[] args) {
		String a = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		String b =  "1,#";
		String c =  "9,#,#,1";
		
		VerifyPreOrderSerializationOfBinaryTree d = new VerifyPreOrderSerializationOfBinaryTree();
		System.out.println(d.isValidSerialization(a));
		System.out.println(d.isValidSerialization(b));
		System.out.println(d.isValidSerialization(c));
		
	}
}
