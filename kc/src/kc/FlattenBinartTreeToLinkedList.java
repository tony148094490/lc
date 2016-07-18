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
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);

		a.left = b;a.right=e;b.left = c;b.right=d;e.right=f;
		
		FlattenBinartTreeToLinkedList x = new FlattenBinartTreeToLinkedList();
		x.flatten(a);
		System.out.println(a.levelOrderTraversal());
	}
    
}
