package kc;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode start = head;
        ListNode second = head.next;
        
        while(second != null && second.next != null) {
        	start = start.next;
        	second = second.next.next;
        }
        
        ListNode next = start.next;
        
        start.next = null;
        
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(next);
        
        ListNode sortedNode = merge(firstHalf,secondHalf);
        
        return sortedNode;
        
    }
    
    private ListNode merge(ListNode a, ListNode b) {
    	ListNode res = new ListNode(-1);
    	ListNode ret = res;
    	while(a != null && b != null) {
    		if(a.val <= b.val) {
    			res.next = a;
    			a = a.next;
    			
    		} else {
    			res.next = b;
    			b = b.next;
    		}
    		res = res.next;
    		res.next = null;
    	}
    	
    	if(a == null) res.next = b;
    	if(b == null) res.next = a;
    	
    	return ret.next;
    }
    
    public static void main(String[] args) {
		ListNode a = new ListNode(9);
		ListNode b = new ListNode(8);
		ListNode c = new ListNode(7);
		ListNode d = new ListNode(6);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(4);
		a.next = b; 
		b.next = c;
		c.next=d;
		d.next=e;
		e.next=f;
		
		System.out.println(a);
		SortList x = new SortList();
		System.out.println(x.sortList(a));
//		System.out.println(x.merge(a, d));
	}
}
