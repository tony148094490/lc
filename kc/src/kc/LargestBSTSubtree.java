package kc;

public class LargestBSTSubtree {
	
	int res = 1;
	int min = Integer.MIN_VALUE;
	int max = Integer.MAX_VALUE;

	public int largestBSTSubtree(TreeNode root) {
		if(root == null) return 0;
		helper(root);
		return res;
	}
	
	private int[] helper(TreeNode root) {
		if(root == null) return new int[] {0,max,min};
		
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		
		if(left[0] == -1 || right[0] == -1  || root.val <= left[2] || root.val >= right[1]) {
			return new int[] {-1, 0,0};
		}
		
		res = Math.max(res, left[0] + right[0] + 1);
		return new int[] {left[0] + right[0] + 1, Math.min(left[1], root.val), Math.max(right[2], root.val)};	
	}
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(7);
		
		a.left=b;a.right=c;c.left=d;
		LargestBSTSubtree x = new LargestBSTSubtree();
		System.out.println(a.levelOrderTraversal());
		System.out.println(x.largestBSTSubtree(a));
	}
}
