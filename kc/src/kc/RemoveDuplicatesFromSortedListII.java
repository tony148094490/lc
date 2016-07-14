package kc;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode res = new ListNode(-1);
        
        
        ListNode prev = res;
  
        ListNode prevPointer = new ListNode(-1);
        prevPointer.next = head;
        ListNode pointer = head;
        
        while(pointer != null && pointer.next != null) {        	
        	if(pointer.val == pointer.next.val) {
        		while(pointer != null && pointer.next != null && pointer.val == pointer.next.val) {
        			pointer = pointer.next;
        			prevPointer = prevPointer.next;
        		}
        		if(pointer != null) {
        			pointer = pointer.next;
        			prevPointer = prevPointer.next;
        		}
        	} else {
        		prev.next = pointer;
        		prev = prev.next;
          		pointer = pointer.next;
          		prevPointer = prevPointer.next;
        	}
        }
        
        if(pointer != null && prevPointer.val != pointer.val) {
        	prev.next = pointer;
        } else {
        	prev.next = null;
        }
        
        
        
        return res.next;
    }
    
    public static void main(String[] args) {
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(2);

    	
    	a.next=b;b.next=c;//c.next=d;d.next=e;e.next=f;f.next=g;
    	
    	RemoveDuplicatesFromSortedListII x = new RemoveDuplicatesFromSortedListII();
    	System.out.println(x.deleteDuplicates(a));
    	
    }
}
