package kc;

import java.util.Stack;

public class BSTIterator {
	
	Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while(root != null) {
        	stack.push(root);
        	root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop();
        TreeNode right = res.right;
        while(right != null) {
            stack.push(right);
            right = right.left;
        }
        return res.val;
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		c.left = b;
		b.left = a;
		c.right = e;
		e.left = d;
		e.right = f;
		
		BSTIterator i = new BSTIterator(c);
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	}
}
