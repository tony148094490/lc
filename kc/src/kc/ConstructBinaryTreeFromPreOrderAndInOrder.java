package kc;

public class ConstructBinaryTreeFromPreOrderAndInOrder {
    
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder, inorder, 0, preorder.length -1, 0, inorder.length-1);
    }
	
	private TreeNode helper(int[] preorder, int[] inorder, int lp, int rp, int li, int ri) {
		if(lp > rp || lp >= preorder.length) return null;
		if(li > ri || li >= inorder.length) return null;
		
		TreeNode root = new TreeNode(preorder[lp]);
		int pos = 0;
		while(inorder[li + pos] != root.val) {
			pos++;
		}
		root.left = helper(preorder,inorder,lp+1,lp + pos, li, li + pos - 1);
		root.right = helper(preorder,inorder,lp+pos+1, rp, li+pos+1, ri);
		return root;
	}
	
	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
