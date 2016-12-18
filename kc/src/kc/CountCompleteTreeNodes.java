package kc;

public class CountCompleteTreeNodes {
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = get(root.left);
        int right = get(root.right);
        if(left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << (left -1));
        }
    }
    
    private int get(TreeNode r) {
        int i = 0;
        while(r != null) {
            i++;
            r = r.left;
        }
        return i;
    }
	
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		
		a.left = b; a.right = c;
		b.left = d;b.right = e;c.left = f;
		
		CountCompleteTreeNodes x = new CountCompleteTreeNodes();
		System.out.println(x.countNodes(a));
	}
}
