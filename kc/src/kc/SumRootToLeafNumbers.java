package kc;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    
    private int helper(TreeNode root, int curSum) {
    	if(root == null) return 0;
    	if(root.left == null && root.right == null) {
    		return curSum * 10 + root.val;
    	}
    	return helper(root.left, curSum  * 10 + root.val) + helper(root.right,
    			curSum * 10 + root.val);
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		
		a.left = b;a.right = c;b.left =d;b.right=e;c.left=f;c.right=g;
		SumRootToLeafNumbers x = new SumRootToLeafNumbers();
		System.out.println(x.sumNumbers(a));
	}
}
