package kc;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int counter = 0;
        if(head == null || head.next == null) return true;
        ListNode cur = head;
        while(cur != null) {
        	counter++;
        	cur = cur.next;
        }
        counter = counter / 2;
        cur = head;
        while(counter > 0) {
        	cur = cur.next;
        	counter--;
        }
        ListNode tail = reverse(cur);
        while(tail != null && head != null) {
        	if(tail.val != head.val) return false;
        	tail = tail.next;
        	head = head.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
    	if(head.next == null) return head;
    	ListNode next = head.next;
    	ListNode cur = head;
    	ListNode prev = null;
    	while(next != null) {
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    		next = next.next;
    	}
    	cur.next = prev;
    	return cur;
    }
    
    public static void main(String[] args) {
    	PalindromeLinkedList x = new PalindromeLinkedList();
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(2);
    	ListNode d = new ListNode(1);
//    	ListNode e = new ListNode(3);
//    	ListNode f = new ListNode(1);
    	
    	a.next=b;b.next=c;c.next=d;//e;d.next=e;e.next=f;
    	System.out.println(x.isPalindrome(a));
	}
}
