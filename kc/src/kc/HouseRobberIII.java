package kc;

public class HouseRobberIII {
    public int rob(TreeNode root) {
    	if(root == null) return 0;
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] helper(TreeNode root) {
    	
    	int[] left = {0,0};
    	if(root.left != null) {
    		left = helper(root.left);
    	}
    	
    	int[] right = {0,0};
    	if(root.right != null) {
    		right = helper(root.right);
    	}
    	
    	int[] res = new int[2];
    	
    	// no use cur val
    	res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    	
    	// use cur val
    	res[1] = left[0] + right[0] + root.val;
    	
    	return res;
    }
}
