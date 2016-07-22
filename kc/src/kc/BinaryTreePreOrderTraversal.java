package kc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();       	
        	if(node.right != null) {
        		stack.push(node.right);
        	}
        	res.add(node.val);
        	if(node.left != null) {
        		while(node.left != null) {
        			node = node.left;        			
        			if(node.right != null)
        			stack.push(node.right);
        			res.add(node.val);
        		}
        	}
        }
        return res;
    }
    
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		
		a.left = b;a.right = c;b.left=d;b.right=e;c.left = f;
		BinaryTreePreOrderTraversal x = new BinaryTreePreOrderTraversal();
		System.out.println(x.preorderTraversal(a));
		
	}
}
