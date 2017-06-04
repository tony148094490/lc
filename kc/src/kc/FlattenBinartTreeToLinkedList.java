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

    	prev.right = root;
    	root.left = prev;
    	prev = root;
    	
    	if(root.right != null)
    	prev = dfs(root.right, prev);
    	
    	return prev;
    }
    
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);

		a.left = b;a.right=e;b.left = c;b.right=d;e.right=f;
		
		FlattenBinartTreeToLinkedList x = new FlattenBinartTreeToLinkedList();
		TreeNode root = x.find(a);
		while(root != null) {
			System.out.print(root.val);
			root = root.left;
		}
	}
    
}

