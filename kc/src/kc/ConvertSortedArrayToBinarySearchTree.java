package kc;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
    	return helper(nums,0,nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int l, int r) {
    	if(l > r) return null;
    	
    	int m = (l+r) / 2;
    	
    	TreeNode root = new TreeNode(nums[m]);
    	root.left = helper(nums,l,m-1);
    	root.right = helper(nums,m+1,r);
    	return root;
    }
    
    public static void main(String[] args) {
    	ConvertSortedArrayToBinarySearchTree a = new ConvertSortedArrayToBinarySearchTree();
    	int[] arr = {1,2,3,4,5,6,7};
    	TreeNode x = a.sortedArrayToBST(arr);
    	BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
    	
    	System.out.println(b.levelOrder(x));
	}
    
}
