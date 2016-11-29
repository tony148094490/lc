package kc;

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
    	if(head == null) return null;
    	int carry = dfs(head);
    	if( carry == 1) {
    		ListNode res = new ListNode(1);
    		res.next = head;
    		return res;
    	} else {
    		return head;
    	}
    }
    
    private int dfs(ListNode head) {
    	if(head.next == null) {
    		int carry = (1 + head.val) / 10;
    		head.val = (1 + head.val) % 10;
    		return carry;
    	} else {
    		int carry = dfs(head.next);
    		int newCarry = (carry + head.val) / 10;
    		head.val = (carry + head.val) % 10;
    		return newCarry;
    	}
    }
    
    public static void main(String[] args) {
		ListNode a = new ListNode(9);
		ListNode b = new ListNode(9);
		ListNode c = new ListNode(9);
		a.next = b; b.next = c;
		PlusOneLinkedList x = new PlusOneLinkedList();
		System.out.println(x.plusOne(a));
	}
}
