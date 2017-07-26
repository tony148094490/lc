package fb;

public class BSTToDDL {
	
	TreeNode head = null;
	TreeNode tail = null;
	public TreeNode flatten(TreeNode root) {
		tail = getTail(root, null);
		head.left = tail;
		tail.right = head;
		return head;
	}
	
	private TreeNode getTail(TreeNode cur, TreeNode prev) {
		if(cur == null) return null;
		if(cur.left == null && cur.right == null) {
			if(head == null) {
				head = cur;
				prev = cur;
				return cur;
			} else {
				prev.right = cur;
				cur.left = prev;
				prev = cur;
				return prev;
			}
		} else if(cur.left == null) {
			if(head == null) {
				head = cur;
				prev = cur;
				return getTail(cur.right, cur);
			} else {
				cur.left = prev;
				prev.right = cur;
				return getTail(cur.right, cur);
			}
		} else if(cur.right == null) {
			TreeNode tail = getTail(cur.left, prev);
			cur.left = tail;
			tail.right = cur;
			return cur;
		} else {
			TreeNode left = getTail(cur.left, prev);
			TreeNode right = getTail(cur.right, cur);
			cur.left = left;
			left.right = cur;
			return right;
		}
	}
	
	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int v;
		public TreeNode(int value) {
			v = value;
			left = null;
			right = null;
		}
	}
}
