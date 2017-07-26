package fb;

public class ArrayToHeapTree {
	public TreeNode build(int[] input) {
		return helper(input, 0, input.length-1);
	}
	
	private TreeNode helper(int[] input, int left, int right) {
		if(left > right) return null;
		
		if(left == right) {
			return new TreeNode(input[left]);
		}
		
		int index = 0;
		int min = Integer.MAX_VALUE;
		for(int i = left ; i <= right; i++) {
			if(input[i] < min) {
				min = input[i];
				index = i;
			}
		}
		
		TreeNode root = new TreeNode(min);
		root.left = helper(input, left, index-1);
		root.right = helper(input, index+1, right);
		return root;
	}
	
	private void addNode(int i, TreeNode root) {
		if(root == null) root = new TreeNode(i);
		addNode(i, root, null);
	}
	
	private void addNode(int i, TreeNode cur, TreeNode parent) {
		if(i > cur.val) {
			if(cur.right == null) {
				cur.right = new TreeNode(i);
			} else {
				addNode(i, cur.right, cur);
			}
		} else {
			TreeNode newNode = new TreeNode(i);
			if(parent != null) {
				parent.right = newNode;
				newNode.left = cur;
			} else {
				newNode.left = cur;
				// root = newNode;
			}
		}
	}
	
	private class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int v) {
			val = v;
			left = null;
			right = null;
		}
		
	}
}
