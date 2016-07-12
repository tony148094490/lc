package kc;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null || head.next == null || k <= 0) return head;
    	
    	ListNode end = head;
    	int len = 0;
    	
    	while(end != null) {
    		len++;
    		end = end.next;
    	}
    	
    	k = k % len;
    	if(k == 0) return head;

    	ListNode start = head;
    	ListNode second = head;
    	
        while(k > 0) {
        	start = start.next;
        	k--;
        }

        while(start.next != null) {
        	start = start.next;
        	second = second.next;
        }
        
        start.next = head;
        
        ListNode res = second.next;
        second.next = null;
        
        return res;
    }
    
    public static void main(String[] args) {
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(4);
    	ListNode e = new ListNode(5);
    	ListNode f = new ListNode(6);
    	a.next = b;b.next=c;c.next=d;d.next=e;e.next=f;
    	RotateList r = new RotateList();
    	
    	System.out.println(a);
    	
    	System.out.println(r.rotateRight(a, 6));
    	
    }
}
