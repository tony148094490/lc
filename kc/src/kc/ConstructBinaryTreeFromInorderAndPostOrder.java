package kc;

public class ConstructBinaryTreeFromInorderAndPostOrder {
    
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(postorder, inorder, 0, postorder.length -1, 0, inorder.length-1);
    }
	
	private TreeNode helper(int[] postorder, int[] inorder, int lp, int rp, int li, int ri) {
		if(lp > rp || lp >= postorder.length) return null;
		if(li > ri || li >= inorder.length) return null;
		
		TreeNode root = new TreeNode(postorder[rp]);
		int pos = 0;
		while(inorder[li + pos] != root.val) {
			pos++;
		}
		root.left = helper(postorder,inorder,lp,lp + pos - 1, li, li + pos - 1);
		root.right = helper(postorder,inorder,lp+pos, rp-1, li+pos+1, ri);
		return root;
	}
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
