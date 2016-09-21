package kc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(root == null) return res;
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode lastNodeVisited = null;
    	
    	while(root != null) {
    		stack.add(root);
    		root = root.left;
    	}
    	
    	while(!stack.isEmpty()) {
    		TreeNode cur = stack.peek();
    		if(cur.right != null && cur.right != lastNodeVisited) {
    			cur = cur.right;
    			while(cur != null) {
    				stack.push(cur);
    				cur = cur.left;
    			}
    		} else {
    			lastNodeVisited = stack.pop();
    			res.add(lastNodeVisited.val);
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(7);
		TreeNode g = new TreeNode(1);
		
		a.left = b;a.right = e;b.left = c;b.right = d;e.left = f;c.right = g;
		
		BinaryTreePostOrderTraversal x = new BinaryTreePostOrderTraversal();
		System.out.println(x.postorderTraversal(a));
		
	}
}
