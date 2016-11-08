package kc;

public class CountUniValueSubtrees {
	int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        isUniValue(root);
        return res;
    }
    
    private boolean isUniValue(TreeNode root) {
    	if(root.left == null && root.right == null) {
    		res++;
    		return true;
    	}
    	
    	boolean left = true;
    	if(root.left != null){
    		left = isUniValue(root.left);
    	}
    	boolean right = true;
    	if(root.right != null){
    		right = isUniValue(root.right);
    	}
    	
    	if(root.left == null) {
    		if(right && root.right.val == root.val) {
    			res++;
    			return true;
    		}
    		return false;
    	} else if (root.right == null) {
    		if(left && root.left.val == root.val) {
    			res++;
    			return true;
    		}
    		return false;
    	} else {
    		if(left && right && root.val == root.left.val && root.val == root.right.val){
    			res++;
    			return true;
    		}
    		return false;
    	}
    }
    
    public static void main(String[] args) {
    	TreeNode a = new TreeNode(5);
    	TreeNode b = new TreeNode(1);
    	TreeNode c = new TreeNode(5);
    	TreeNode d = new TreeNode(5);
    	TreeNode e = new TreeNode(5);
    	TreeNode f = new TreeNode(5);
    	a.left=b;a.right=c;b.left=d;b.right=e;c.right=f;
    	CountUniValueSubtrees x = new CountUniValueSubtrees();
    	System.out.println(x.countUnivalSubtrees(a));
    }
}
