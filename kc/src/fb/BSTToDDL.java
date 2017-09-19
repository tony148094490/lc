package fb;

import kc.TreeNode;

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
	
	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int v;
		public TreeNode(int value) {
			v = value;
			left = null;
			right = null;
		}
	}
	
	TreeNode front = null;
	TreeNode back = null;
	
	public TreeNode find3(TreeNode root) {
		back = get(root, null);
		front.left = back;
		back.right = front;
		return front;
	}
	
	private TreeNode get(TreeNode cur, TreeNode prev) {
		if(cur == null) return null;
		if(cur.left == null && cur.right == null) {
			if(prev == null) {
				prev = cur;
				front = cur;
				return cur;
			}
			prev.right = cur;
			cur.left = prev;
			prev = cur;
			return cur;
			
		} else if(cur.left == null) {
			if(prev == null) {
				prev = cur;
				front = cur;
				return get(cur.right, prev);
			} else {
				prev.right = cur;
				cur.left = prev;
				prev = cur;
				return get(cur.right, prev);
			}
		} else if(cur.right == null) {
			TreeNode leftTail = get(cur.left, prev);
			leftTail.right = cur;
			cur.left = leftTail;
			prev = cur;
			return cur;
		} else {
			TreeNode leftTail = get(cur.left, prev);
			cur.left = leftTail;
			leftTail.right = cur;
			prev = cur;
			return get(cur.right, prev);
		}
	}
	
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);

		a.right=e;b.left = c;b.right=d;e.right=f;
		//a.right=e;b.prev = c;b.next = d; e.prev = f;
		BSTToDDL x = new BSTToDDL();
		TreeNode root = x.find3(a);
		while(root != null) {
			System.out.print(root.v);
			root = root.right;
		}
	}
    
}
