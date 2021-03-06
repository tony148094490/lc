package kc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        Queue<TreeNode> prevQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> curQueue = new LinkedList<TreeNode>();
        
        prevQueue.add(root);
        
        while(!prevQueue.isEmpty()) {
        	List<Integer> curLevel = new ArrayList<Integer>();
        	while(!prevQueue.isEmpty()) {
        		TreeNode parentNode = prevQueue.poll();
        		curLevel.add(parentNode.val);
        		if(parentNode.left != null) curQueue.add(parentNode.left);
        		if(parentNode.right!= null) curQueue.add(parentNode.right);
        	}
        	res.add(curLevel);
        	prevQueue = curQueue;
        	curQueue = new LinkedList<TreeNode>();
        }
        return res;
    }
    
    public static void main(String[] args) {
    	TreeNode a = new TreeNode(1);
    	TreeNode b = new TreeNode(2);
    	TreeNode c = new TreeNode(3);
    	TreeNode d = new TreeNode(4);
    	a.left = b; a.right = c;c.left = d;
    	BinaryTreeLevelOrderTraversal x = new BinaryTreeLevelOrderTraversal();
    	System.out.println(x.levelOrder(a));
    }
}
