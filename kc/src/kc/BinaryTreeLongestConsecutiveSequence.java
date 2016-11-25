package kc;

public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        return getLongest(root, null, 1);
    }
    
    private int getLongest(TreeNode cur, Integer parent, int max) {
    	if(cur == null) return max;
    	int res = max;
    	if(parent != null && cur.val  == parent + 1) {
    		max = max + 1;
    	} else {
    		max = 1;
    	}
    	
    	int left = getLongest(cur.left, cur.val, max);
    	int right = getLongest(cur.right, cur.val, max);
    	
    	return Math.max(Math.max(left, right),res);
    }
    
    public static void main(String[] args) {
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(1);
		a.right = b;b.left = c;c.left = d;
		
		BinaryTreeLongestConsecutiveSequence x = new BinaryTreeLongestConsecutiveSequence();
		System.out.println(x.longestConsecutive(a));
	}
}
