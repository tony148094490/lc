package kc;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null) return head;
    	
    	ListNode a = new ListNode(-1);
        ListNode res = a;
        ListNode b = head;
        ListNode c = head.next;
        
        while(b != null && c != null) {
        	swap(a,b,c);
        	a = a.next.next;
        	b = a.next;
        	c = b == null ? null : b.next;
        }
        
        return res.next;
    }
    
    private void swap(ListNode a, ListNode b, ListNode c) {
    	b.next = c.next;
    	a.next = c;
    	c.next = b;
    }
    
    public static void main(String []args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		
		a.next=b;b.next=c;c.next=d;d.next=e;//e.next=f;
		SwapNodesInPairs s = new SwapNodesInPairs();
		System.out.println(s.swapPairs(a));
    }
}
