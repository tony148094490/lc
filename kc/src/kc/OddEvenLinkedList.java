package kc;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        
        ListNode res = even;
        
        while(odd.next != null && even.next != null) {
        
	        if(even.next != null) {
	        	odd.next = even.next;
	        	odd = odd.next;
	        }
	        
	        if(odd.next != null) {
	        	even.next = odd.next;
	        	even = even.next;
	        }
        
        }
        
        if(even.next != null) even.next = null;
        
        odd.next = res;
        return head;
    }
    
    public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		
		a.next = b; b.next = c; c.next = d; d.next = e;
		
		OddEvenLinkedList list = new OddEvenLinkedList();
		
		System.out.println(list.oddEvenList(a));
		
	}
}
