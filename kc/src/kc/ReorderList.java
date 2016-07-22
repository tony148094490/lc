package kc;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode start = head;
        ListNode end = head;
        
        while(end != null && end.next != null) {
        	start = start.next;
        	end = end.next.next;
        }

        ListNode next = start.next;
        
        ListNode prev1 = start;
        start.next = null;
        ListNode prev2 = next;
        
        while(prev2 != null) {
        	

        	next = next.next;
        	prev2.next = prev1;
        	prev1 = prev2;
        	prev2 = next;
        }
                
        //prev1 is the tail;
        start = head;
        while(start != null && prev1 != null && prev1.next != null) {
        	next = start.next;
        	prev2 = prev1.next;

        	if(start == prev1) System.out.println("true");
        	
        	start.next = prev1;
        	prev1.next = next;
        	
        	
        	
        	start = next;
        	prev1 = prev2;
        	

        }
       

    }
    
    public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		ListNode g = new ListNode(7);
		ListNode h = new ListNode(8);
		a.next = b;b.next=c;c.next=d;d.next=e;e.next=f;f.next=g;g.next=h;
		ReorderList x = new ReorderList();
		x.reorderList(a);
		System.out.println(a);
	}
}
