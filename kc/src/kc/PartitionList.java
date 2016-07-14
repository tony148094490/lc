package kc;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode res = left;
        ListNode secondHalf = right;
        while(head != null) {
        	if(head.val < x) {
        		left.next = head;
            	head = head.next;
        		left = left.next;
        		left.next = null;
        	} else {
        		right.next = head;
            	head = head.next;
        		right = right.next;
        		right.next = null;
        	}
        }
        
        left.next = secondHalf.next;
        return res.next;
    }
    
    public static void main(String[] args) {
    	
    }
}
