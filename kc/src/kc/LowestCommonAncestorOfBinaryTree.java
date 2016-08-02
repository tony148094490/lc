package kc;


public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {    
    	if(root == null || root == p || root == q) return root;
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	if(left != null && right != null) return root;
    	return left != null ? left : right;
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(-1);
		TreeNode b = new TreeNode(0);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(-2);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(8);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		d.left = f;
		LowestCommonAncestorOfBinaryTree x = new LowestCommonAncestorOfBinaryTree();
		System.out.println(x.lowestCommonAncestor(a, e, f).val);
			
	}
}
