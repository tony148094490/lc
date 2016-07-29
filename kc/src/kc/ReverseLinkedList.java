package kc;

import java.util.Stack;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode tail = reverseList(next);
        next.next = head;
        return tail;
    }
    
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
    	ListNode next = head.next;
    	ListNode cur = head;
    	cur.next = null;
    	while(next != null) {
    		ListNode nextNext = next.next;
    		next.next = cur;
    		cur = next;
    		next = nextNext;
    	}
    	
        return cur;
    }
    
    public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next=b;b.next=c;c.next=d;d.next=e;
		System.out.println(a);
		ReverseLinkedList x = new ReverseLinkedList();
		System.out.println(x.reverseList(a));
		System.out.println(x.reverseList2(e));
	}
}
