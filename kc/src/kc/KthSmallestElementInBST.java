package kc;


public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        int left = nrOfNodesOn(root.left);
        if(k <= left) {
        	return kthSmallest(root.left, k);
        } else if(k > left + 1) {
        	return kthSmallest(root.right, k - 1 - left);
        }
        return root.val;
    }
    
    private int nrOfNodesOn(TreeNode root) {
    	if(root == null) return 0;
    	return nrOfNodesOn(root.left) + 1 + nrOfNodesOn(root.right);
    }
}
