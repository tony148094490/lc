package fb;

import kc.TreeNode;

public class ReconstructBSTFromPreorder {
	public TreeNode constructFromPreorder(int[] preorder) {
		return helper(preorder, 0, preorder.length-1);
	}
	
	private TreeNode helper(int[] arr, int left, int right) {
		if(left > right) return null;
		if(left == right) return new TreeNode(arr[left]);
		
		TreeNode root = new TreeNode(arr[left]);
		
		int rightIndex = left + 1;
		while(rightIndex < arr[right] && arr[rightIndex] < root.val) {
			rightIndex++;
		}
		
		if(rightIndex > left + 1) {
			root.left = helper(arr, left + 1, rightIndex - 1);
		}
		
		if(rightIndex <= right) {
			root.right = helper(arr, rightIndex, right);
		}
		
		return root;
	}
}
