package kc;

public class BinaryTreeUpsideDown {
    
    private TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root.left == null) {
        	return root;
        }
        
        TreeNode r = root;
        TreeNode l = root.left;
        TreeNode right = root.right;

        r.left = null;
        r.right = null;
        TreeNode res = upsideDownBinaryTree(l);
        
        l.left = right;        
        l.right = root;
        return res;
    }
    
    public static void main(String[] args) {
    	TreeNode a = new TreeNode(1);
    	TreeNode b = new TreeNode(2);
    	TreeNode c = new TreeNode(3);
    	TreeNode d = new TreeNode(4);
    	TreeNode e = new TreeNode(5);
    	TreeNode f = new TreeNode(6);
    	TreeNode g = new TreeNode(7);
    	TreeNode h = new TreeNode(8);
    	TreeNode i = new TreeNode(9);
    	TreeNode j = new TreeNode(10);
    	TreeNode k = new TreeNode(11);
    	TreeNode l = new TreeNode(12);
    	a.left=b;a.right=c;b.left=d;b.right=e;d.left=f;d.right=g;f.left=h;h.left=i;i.left=j;i.right=k;h.right=l;
    	System.out.println(a.levelOrderTraversal());
    	BinaryTreeUpsideDown x = new BinaryTreeUpsideDown();
    	System.out.println(x.upsideDownBinaryTree(a).levelOrderTraversal());
    }
}
