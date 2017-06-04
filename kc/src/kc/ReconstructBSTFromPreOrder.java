package kc;

public class ReconstructBSTFromPreOrder {

	public TreeNode recon(int[] preorder) {
		return helper(preorder, 0, preorder.length-1);
	}
	
	private TreeNode helper(int[] preorder, int start, int end) {
		if(start > end || start >= preorder.length) return null;
		TreeNode root = new TreeNode(preorder[start]);
		if(start == end) return root;
		int rightStart = start+1;
		while(rightStart < preorder.length && 
				preorder[rightStart] <= root.val) rightStart++;
		root.left = helper(preorder, start+1, rightStart-1);
		root.right = helper(preorder, rightStart, preorder.length-1);
		return root;
	}
}
