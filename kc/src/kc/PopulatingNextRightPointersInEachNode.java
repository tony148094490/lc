package kc;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        TreeLinkNode left = root.left;
        while(left != null) {
        	root.left.next = root.right;
        	if(root.next != null) {
        		root.right.next = root.next.left;
        		root = root.next;
        	} else {
        		root = left;
        		left = root.left;
        	}
        }
        
    }
    
    
    public static void main(String[] args) {
		
	}
}
