package kc;

import java.util.Stack;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(true) {
            stack.push(root);
            if(root == p) break;
            if(root.val >= p.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        TreeNode cur = stack.pop();
        if(cur.right != null || stack.isEmpty()) {
            return getSmallest(cur.right);
        }
        
        while(!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            if(parent.right != cur) {
                return parent;
            } else {
                cur = parent;
            }
        }
        
        return null;
    }
    
    private TreeNode getSmallest(TreeNode node) {
        if(node == null) return null;
        if(node.left == null) return node;
        return getSmallest(node.left);
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
