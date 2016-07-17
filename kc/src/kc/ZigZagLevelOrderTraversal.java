package kc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root == null) return res;
    	LinkedList<TreeNode> prev = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
    	boolean goLeft = false;
    	prev.add(root);
    	while(!prev.isEmpty()){
    		List<Integer> curLevel = new ArrayList<Integer>();
    		if(goLeft) {
    			while(!prev.isEmpty()) {
        			TreeNode node = prev.pollLast();
        			curLevel.add(node.val);
        			if(node.right != null) cur.add(node.right);
        			if(node.left != null) cur.add(node.left);
        		}	
    			goLeft = false;

    		} else {
    			while(!prev.isEmpty()) {
    				TreeNode node = prev.pollLast();
    				curLevel.add(node.val);
    				if(node.left != null ) cur.add(node.left);
    				if(node.right != null) cur.add(node.right);
    			}
    			goLeft = true;
    		}
    		res.add(curLevel);
    		prev = cur;
    		cur = new LinkedList<TreeNode>();
    	}
    	return res;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagLevelOrderTraversal x = new ZigZagLevelOrderTraversal();
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		a.left = b;
		a.right = c;
		c.left = d;
		d.right = e;
		
		System.out.println(x.zigzagLevelOrder(a));
		
	}

}
