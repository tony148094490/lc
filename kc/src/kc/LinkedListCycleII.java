package kc;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                fast = head;
                while(slow!=fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		ListNode g = new ListNode(7);
		ListNode h = new ListNode(8);
		a.next=b;b.next=c;c.next=d;d.next=e;e.next=f;f.next=g;g.next=h;
		LinkedListCycleII x = new LinkedListCycleII();
		System.out.println(x.detectCycle(a));
	}
}
