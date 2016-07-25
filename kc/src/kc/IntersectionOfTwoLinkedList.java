package kc;

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        		
    	ListNode a = headA;
        ListNode b = headB;
        int lenA = 0;
        int lenB = 0;
        
        while(a != null && b != null) {
        	lenA++;
        	lenB++;
        	a = a.next;
        	b = b.next;
        }
        
        if(a == null) {
        	while(b != null) {
        		lenB++;
        		b = b.next;
        	}
        } else if (b == null) {
        	while(a != null) {
        		lenA++;
        		a = a.next;
        	}
        }
        
        a = headA;
        b = headB;
        if(lenA > lenB) {
        	while(lenA > lenB) {
        		a = a.next;
        		lenA--;
        	}
        } else {
        	while(lenB > lenA) {
        		b = b.next;
        		lenB--;
        	}
        }
        
        while(a != null && b != null && a != b) {
        	a = a.next;
        	b = b.next;
        }
        return a;
    }
}
