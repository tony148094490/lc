package kc;
/**
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5 
*/
public class ReverseNodesInKGroup {
	
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode res = start;
        ListNode first = head;
        ListNode second = head.next;
        ListNode last = second.next;
        
        int counter = k;
        while(counter > 1) {
        	counter--;
        	if(counter == 1) {
	        	second.next = null;
	        	ListNode tail = reverseList(first);
	        	start.next = tail;
	        	first.next = last;
	        	counter = k;
	        	
	        	if(last != null && last.next != null) {
	        		start = first;
	        		first = last;
	        		second = last.next;
	        		last = second.next;
	        	} else {
	        		break;
	        	}
        	} else {
        		if(last != null) {
        			second = second.next;
        			last = last.next;
        		} else {
        			break;
        		}
        	}        	
        }
        return res.next;	
    }	
    
    private ListNode reverseList(ListNode head) {
    	if(head.next == null) return head;
    	ListNode next = head.next;
    	head.next = null;
    	ListNode tail = reverseList(next);
    	next.next = head;
    	return tail;
    }
    
    
	public static void main(String[] args) {
		ReverseNodesInKGroup x = new ReverseNodesInKGroup();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;b.next=c;c.next=d;d.next=e;
		System.out.println(x.reverseKGroup(a, 1));
	}
}
