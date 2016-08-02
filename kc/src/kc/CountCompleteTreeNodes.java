package kc;

public class CountCompleteTreeNodes {
    
	public int countNodes(TreeNode root) {
		int height = getHeight(root);
		if(height == 0) return 0;
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		if(leftHeight == rightHeight) {
			return countNodes(root.right) + (1 << (height-1) - 1);
		} else {
			return countNodes(root.left) + (1 << (height-2) - 1); 
		}
		
    }
	
	private int getHeight(TreeNode root) {
		if(root == null) return 0;
		int height = 1;
		while(root != null) {
			root = root.left;
			height++;
		}
		return height;
	}
	
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		
		a.left = b; a.right = c;
		b.left = d;b.right = e;
		
		CountCompleteTreeNodes x = new CountCompleteTreeNodes();
		System.out.println(x.countNodes(a));
	}
}
