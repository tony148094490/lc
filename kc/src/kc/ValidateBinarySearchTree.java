package kc;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
    	if(root == null) return true;
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE, false, false);
    }
    
    private boolean helper(TreeNode root, int min, int max, boolean visitedLeftMost, boolean visitedRightMost) {
    	if(root == null) return true;
    	
    	if(root.val == Integer.MIN_VALUE && min == Integer.MIN_VALUE) {
    		if(visitedLeftMost == false && root.left == null) {
    			return helper(root.right, min, max, true, visitedRightMost);
    		} else {
    			return false;
    		}
    	}
    	
    	if(root.val == Integer.MAX_VALUE && min == Integer.MAX_VALUE) {
    		if(visitedRightMost == false && root.right == null) {
    			return helper(root.left, min, max, visitedLeftMost, true);
    		} else {
    			return false;
    		}
    	}
    	
    	if(root.val <= min || root.val >= max) return false;
    	
    	if(helper(root.left, min, root.val, visitedLeftMost, visitedRightMost) == false) return false;
    	
    	return helper(root.right, root.val, max, visitedLeftMost, visitedRightMost);
    }
    
}
