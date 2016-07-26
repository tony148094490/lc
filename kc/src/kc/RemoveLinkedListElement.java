package kc;

public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(-1);
        ListNode mover = res;
        ListNode pointer = head;
        while(pointer != null) {
            if(pointer.val == val) {
                while(pointer != null && pointer.val == val) {
                    pointer = pointer.next;
                }
            }
            
            if(pointer != null) {
                mover.next = pointer;
            } else {
                break;
            }
            
            pointer = pointer.next;
            mover = mover.next;
            mover.next = null;
        }
        return res.next;
    }
}
