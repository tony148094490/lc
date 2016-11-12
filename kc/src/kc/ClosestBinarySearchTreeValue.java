package kc;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
    
    	if(root == null) return -1;
    	
    	if(root.val == target) return root.val;

    	if(root.val > target) {
    		double diff = root.val - target;
    		if(root.left == null) return root.val;
    		int left = closestValue(root.left, target);
    		double leftDouble = Math.abs(left - target);
    		if(diff < leftDouble) {
    			return root.val;
    		}
    		return left;
    	} else {
    		double diff = target - root.val;
    		if(root.right == null) return root.val;
    		int right = closestValue(root.right, target);
    		double rightDouble = Math.abs(right - target);
    		if(diff < rightDouble) {
    			return root.val;
    		}
    		return right;
    	}
    	
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(100);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(99);
		TreeNode d = new TreeNode(2);
		TreeNode e = new TreeNode(98);
		TreeNode f = new TreeNode(3);
		a.left = b;
		b.right = c;
		c.left = d;
		d.right = e;
		e.left = f;
		ClosestBinarySearchTreeValue x = new ClosestBinarySearchTreeValue();
		System.out.println(x.closestValue(a, 50.5));
	}
    
}
