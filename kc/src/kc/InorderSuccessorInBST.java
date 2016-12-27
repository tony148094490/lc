package kc;

import java.util.Stack;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != p) {
            stack.push(root);
            if(root.val <= p.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if(root.right != null) {
            return getSmallest(root.right);
        }
        while(!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            if(parent.left == root) return parent;
            root = parent;
        }
        return null;
    }
    
    private TreeNode getSmallest(TreeNode root) {
        while(root.left != null) root = root.left;
        return root;
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		a.right = e;
		e.left = b;
		b.right = d;
		d.left = c;
		InorderSuccessorInBST x = new InorderSuccessorInBST();
		System.out.println(x.inorderSuccessor(a, e));
		
	}
}
