package kc;

import java.util.Stack;

public class RecoverBST {
    public void recoverTree(TreeNode root) {
    	if(root == null || (root.left == null && root.right == null)) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode prev = root;

        while(cur != null) {
        	stack.push(cur);
        	prev = cur;
        	cur = cur.left;
        }
        
        TreeNode first = null;
        TreeNode second = null;
        
        while(!stack.isEmpty()) {
        	cur = stack.pop();
        	if(cur.val < prev.val) {
        		if(first == null) {
        			first = prev;
        		} else {
        			second = cur;
        			break;
        		} 
        	} else if(first != null && first.val < cur.val) {
        		second = prev;
        		break;
        	}
        	
        	prev = cur;
        	if(cur.right != null) {
        		cur = cur.right;
        		while(cur != null) {
        			stack.push(cur);
        			cur = cur.left;
        		}
        	}
        	
        }
        
        if(second == null) {
        	second = prev;
        }
                
        if(first != null && second != null) {
        	int temp = first.val;
        	first.val = second.val;
        	second.val = temp;
        }
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		
		
		d.left = b;
		b.left = a;
		b.right = c;
		d.right = f;
		f.left = e;
		f.right = g;
		
		System.out.println(d.levelOrderTraversal());
		
		RecoverBST x = new RecoverBST();
		x.recoverTree(d);
		
		System.out.println(d.levelOrderTraversal());
	

		
		
	}
}
