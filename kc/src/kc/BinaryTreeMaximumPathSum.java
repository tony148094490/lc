package kc;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        
        return helper(root)[1];
    }
    
    public int[] helper(TreeNode root) {
    	int[] res = new int[2];
    	if(root.left == null && root.right == null) {
    		res[0] = root.val;
    		res[1] = root.val;
    	}
    	
    	int[] left = new int[2];
    	if(root.left != null) {
    		left = helper(root.left);
    	} else {
    		left[0] = Integer.MIN_VALUE;
    		left[1] = Integer.MIN_VALUE;    		
    	}
    	
    	int[] right = new int[2];
    	if(root.right != null) {
    		right = helper(root.right);
    	} else {
    		right[0] = Integer.MIN_VALUE;
    		right[1] = Integer.MIN_VALUE;    		
    	}
    	
    	res[0] = root.val + Math.max(0, Math.max(left[0], right[0]));
    	
		int max = Math.max(Math.max(left[0], left[1]), Math.max(right[0], right[1]));
    	
		if(root.val >= 0 && left[0] >= 0 && right[0] >= 0) {
    		res[1] = Math.max(root.val + left[0] + right[0], max);
    	} else if(root.val >= 0 && left[0] >= 0){
    		res[1] = Math.max(root.val + left[0], max);
    	} else if(root.val >= 0 && right[0] >= 0) {
    		res[1] = Math.max(root.val + right[0], max);
    	} else if(left[0] >= 0 && right[0] >= 0) {
    		res[1] = Math.max(max, root.val + left[0] + right[0]);
    	} else {
    		res[1] = Math.max(max, root.val);
    	}
    	
    	return res;
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(-1);
		TreeNode b = new TreeNode(8);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(-9);
		TreeNode e = new TreeNode(0);
		TreeNode f = new TreeNode(-3);
		TreeNode g = new TreeNode(-9);
		TreeNode h = new TreeNode(2);
		
		
		a.left = b;
		a.right = c;
		b.right = d;
		c.left = e;
		e.left = f;
		f.right = g;
		g.right = h;
		
		BinaryTreeMaximumPathSum x = new BinaryTreeMaximumPathSum();
		System.out.println(x.maxPathSum(a));
	}
}
