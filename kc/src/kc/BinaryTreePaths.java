package kc;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        helper(root, new ArrayList<TreeNode>(), res);
        return res;
    }
    
    private void helper(TreeNode root, List<TreeNode> curRes, List<String> res) {
    	if(root.left == null && root.right == null) {
    	    curRes.add(root);
    		StringBuilder sb = new StringBuilder();
    		for(TreeNode a : curRes) {
    			sb.append("->");
    			sb.append(a.val);
    		}
    		res.add(sb.substring(2));
    		curRes.remove(curRes.size()-1);
    		return;
    	}
    	
    	curRes.add(root);
    	if(root.left != null) {
    		helper(root.left, curRes, res);
    	}
    	
    	if(root.right != null) {
    		helper(root.right, curRes,res);
    	}
    	curRes.remove(curRes.size()-1);
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		a.left = b;a.right = c; b.right = d;
		BinaryTreePaths x = new  BinaryTreePaths();
		System.out.println(x.binaryTreePaths(a));
	}
}
