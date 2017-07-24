package kc;

public class FlattenBinartTreeToLinkedList {
    public void flatten(TreeNode root) {
    	if(root == null) return;
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	root.left = null;
    	root.right = null;
    	
    	root.right = left;
    	flatten(left);
    	
    	while(root.right != null) {
    		root = root.right;
    	}
    	
    	root.right = right;
    	
    	flatten(right);
    }
 
 /**
  * This is better   
  * @param root
  * @return
  */
    public TreeNode find(TreeNode root) {
    	TreeNode tail = dfs(root, null);
    	
    	this.head.left = tail;
    	tail.right = this.head;
    	return this.head;
    }
    TreeNode head = null;
    private TreeNode dfs(TreeNode root, TreeNode prev) {
    	if(root.left == null && root.right == null) {
    		if(prev == null) {
    			prev = root;
    			head = root;
    			return prev;
    		}
    		prev.right = root;
    		root.left = prev;
    		prev = root;
    		return prev;
    	}
    	
    	if(root.left != null)
    	prev = dfs(root.left, prev);

    	if(prev == null) {
    		prev = root;
    		this.head = prev;
    	} else {
	    	prev.right = root;
	    	root.left = prev;
	    	prev = root;
    	}
    	if(root.right != null)
    	prev = dfs(root.right, prev);
    	
    	return prev;
    }
    
    
    public TreeNode find2(TreeNode root) {
    	TreeNode tail = flatten(root, null);
    	first.left = tail;
    	tail.right = first;
    	return first;
    }
	TreeNode first = null;
	public TreeNode flatten(TreeNode root, TreeNode prev) {
		if(root == null) return null;
		
		if(root.left == null && root.right == null) {
			if(first == null) {
				first = root;
				prev = root;
				return root;
			}

			prev.right = root;
			root.left = prev;
			prev = prev.right;
			return prev;
		}

		if(root.left != null && root.right != null) {
			TreeNode left = flatten(root.left, prev);
			left.right = root;
			root.left = left;
			prev = root;
			return flatten(root.right, prev);
		} else if(root.left == null) {
			if(first == null) {
				first = root;
				prev = root;
				return flatten(root.right, prev);
			} else {
				prev.right = root;
				root.left = prev;
				return flatten(root.right, root);
			}
		} else {
			TreeNode left = flatten(root.left, prev);
			left.right = root;
			root.left = left;
			return root;
		}

	}
    

	//TreeNode head = null;
	TreeNode tail = null;
	public TreeNode find3(TreeNode root) {
		tail = helper(root, null);
		head.prev = tail;
		tail.next = head;
		return head;
	}

	private TreeNode helper(TreeNode root, TreeNode prev) {
		if(root == null) return null;
		if(root.left == null && root.right == null) {
			if(head == null) {
				head = root;
				prev = root;
				return root;
			}
			prev.next = root;
			root.prev = prev;
			prev = root;
			return prev;
		}

		if(root.left == null) {
			if(head == null) {
				head = root;
				prev = root;
				return helper(root.right, root);
			}
			prev.next = root;
			root.prev = prev;
			return helper(root.right, root);
		} else if(root.right == null) {
			TreeNode left = helper(root.right, prev);
			left.next = root;
			root.prev = left;
			return root;
		} else {
			TreeNode left = helper(root.right, prev);
			left.next = root;
			root.prev = left;
			return helper(root.right, root);
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
		FlattenBinartTreeToLinkedList x = new FlattenBinartTreeToLinkedList();
		TreeNode root = x.find3(a);
		while(root != null) {
			System.out.print(root.val);
			root = root.next;
		}
	}
    
}

