package kc;

public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            
            
            if(root.left.right == null) {
                root.left.right = root.right;
                return root.left;
            }

            TreeNode res = getLargest(root.left);

            
            res.left = root.left;
            res.right = root.right;
            
            return res;
        }
        
        if(root.left == null && root.right == null) return root;
        
        if(root.left == null && root.val > key) return root;
        
        if(root.right == null && root.val < key) return root;
        
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    
    private TreeNode getLargest(TreeNode root) {
        TreeNode parent = null;
        while(root.right != null) {
            parent = root;
            root = root.right;
        }
        parent.right = null;
        if(root.left != null) {
            parent.right = root.left;
        }
        return root;
    }
}
