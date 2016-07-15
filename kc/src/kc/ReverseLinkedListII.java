package kc;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode res = new ListNode(-1);
    	res.next = head;
    	
    	ListNode prevM = res;
    	prevM.next = head;
    	
    	ListNode M = head;
    	
    	while(m > 1){
    		M = M.next;
    		prevM = prevM.next;
    		m--;
    		n--;
    	}
    	
    	ListNode N = M;
    	ListNode nextN = N.next;
    	M.next = null;
    	ListNode MM = M;
    	while(n > 1) {
    		N = nextN;
    		nextN = nextN.next;
    		N.next = MM;
    		MM = N;
    		
    		n--;
    	}
    	
    	prevM.next = N;
    	M.next = nextN;
    	
    	return res.next;
    }
    
    private ListNode reverse(ListNode head) {
    	if(head.next == null) return head;
    	ListNode next = head.next;
    	head.next = null;
    	ListNode tail = reverse(next);
    	next.next = head;
    	return tail;
    }
    
	public static void main(String[] args) {
		ReverseLinkedListII x = new ReverseLinkedListII();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next=b;b.next=c;c.next=d;d.next=e;
		System.out.println(x.reverseBetween(a,2,2));
		
		
	}

}
