package kc;

public class ConvertSortedListToBinarySearchTree {
    
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        int h = 0;
        ListNode cur = head;
        while(cur != null) {
            h++;
            cur = cur.next;
        }
        int half = h / 2;
        
        cur = head;
        ListNode prev = new ListNode(-1);
        prev.next = cur;
        while(half > 0) {
            cur = cur.next;
            prev = prev.next;
            half--;
        }
        prev.next = null;
        
        TreeNode root = new TreeNode(cur.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(cur.next);
        return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertSortedListToBinarySearchTree a = new ConvertSortedListToBinarySearchTree();
    	ListNode aa = new ListNode(1);
    	ListNode bb = new ListNode(2);
    	ListNode cc = new ListNode(3);
    	ListNode dd = new ListNode(4);
    	ListNode ee = new ListNode(5);
    	ListNode ff = new ListNode(6);
    	aa.next=bb;bb.next=cc;cc.next=dd;dd.next=ee;ee.next=ff;
    	
    	TreeNode x = a.sortedListToBST(aa);
    	BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
    	
    	System.out.println(b.levelOrder(x));

	}

}
