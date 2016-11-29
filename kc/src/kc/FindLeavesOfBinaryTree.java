package kc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        Set<TreeNode> visited = new HashSet<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        while(!visited.contains(root)) {
        	List<Integer> cur = new ArrayList<Integer>();
        	dfs(root, cur, visited);
        	res.add(cur);
        }
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> current, Set<TreeNode> visited) {
    	if(root.left == null && root.right == null) {
    		current.add(root.val);
    		visited.add(root);
    		return;
    	}
    	
    	if(root.left != null && root.right != null && visited.contains(root.left) &&
    			visited.contains(root.right)) {
    		current.add(root.val);
    		visited.add(root);
    		return;
    	} else if(root.left != null && root.right == null && visited.contains(root.left)){
    		current.add(root.val);
    		visited.add(root);
    		return;
    	}  else if(root.right != null && root.left == null && visited.contains(root.right)) {
    		current.add(root.val);
    		visited.add(root);
    		return;
    	}
    	
    	if(root.left != null && !visited.contains(root.left)) dfs(root.left, current, visited);
    	if(root.right != null && !visited.contains(root.right)) dfs(root.right, current, visited);
    	
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		a.left = b;a.right=c;b.left=d;b.right=e;
		FindLeavesOfBinaryTree x = new FindLeavesOfBinaryTree();
		System.out.println(x.findLeaves(a));
	}
}
