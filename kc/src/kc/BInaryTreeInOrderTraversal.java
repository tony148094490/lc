package kc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BInaryTreeInOrderTraversal {
	
	// Recursively
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	helper(root,res);
    	return res;
    }
    
    private void helper(TreeNode root, List<Integer> res) {
    	if(root == null) return;
    	
    	helper(root.left, res);
    	res.add(root.val);
    	helper(root.right, res);
    }
    
    
    //Iteratively
    public List<Integer> inorderTraversalIteratively(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();        
        if(root == null) return res;
        
        TreeNode cur = root;
        stack.add(cur);
        
        while(!stack.isEmpty()) {
        	while(cur != null) {
        		cur = cur.left;
        		
        		if(cur != null)
        		stack.add(cur);
        	}
        	
        	cur = stack.pop();
        	
        	res.add(cur.val);
        	
        	cur = cur.right;
        	
        	if(cur != null) 
        	stack.add(cur);
        	
        	
        }
        
        return res;
    }
    
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		b.left = c; c.left = a;
		
		BInaryTreeInOrderTraversal x = new BInaryTreeInOrderTraversal();
		System.out.println(x.inorderTraversalIteratively(b));
	}
}
