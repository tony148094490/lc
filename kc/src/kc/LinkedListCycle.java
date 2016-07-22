package kc;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        
        while(first != null && second != null && second.next != null) {
        	first = first.next;
        	second = second.next.next;
        	if(first == second) return true;
        }
        
        return false;
    }
}
