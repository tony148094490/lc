package kc;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	if(root == null) return true;
    	
        return helper(root.left,root.right);
    }
    
    private boolean helper(TreeNode a, TreeNode b) {
    	if(a == null) return b == null;
    	if(b == null) return a == null;
    	
    	if(a.val != b.val) return false;
    	
    	if(helper(a.left, b.right) == false) {
    		return false;
    	}
    	return helper(a.right,b.left);
    }
}
