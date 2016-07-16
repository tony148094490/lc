package kc;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) return q == null;
        
        if(q == null) return p == null;
        
        if(p.val != q.val) return false;
        
        if(isSameTree(p.left, q.left) == false) {
            return false;
        }
        return isSameTree(p.right,q.right);
        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
