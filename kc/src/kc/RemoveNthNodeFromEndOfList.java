package kc;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

    if (head == null) return null;
    
    ListNode first = head;
    ListNode second = new ListNode(-1);
    ListNode res = second;
    second.next = head;
    
    while(n > 1 && first != null) {
    	first = first.next;
    	n--;
    }
    
    if(first == null) return head;
    
    while(first.next != null) {
    	first = first.next;
    	second = second.next;
    }
    
    second.next = second.next.next;
    
    return res.next;
    
    
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		
		a.next=b;b.next=c;c.next=d;d.next=e;e.next=f;
		
		RemoveNthNodeFromEndOfList x = new RemoveNthNodeFromEndOfList();
		System.out.println(a);
		System.out.println(x.removeNthFromEnd(a, 1));
	}

}
