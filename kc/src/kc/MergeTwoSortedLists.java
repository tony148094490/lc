package kc;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(-1);
		ListNode cur = res;
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
				cur = cur.next;
				cur.next = null;
			}else {
				cur.next = l2;
				l2 = l2.next;
				cur = cur.next;
				cur.next = null;
			}
		}
		
		if(l1 == null) {
			cur.next = l2;
		} else {
			cur.next = l1;
		}
		
		return res.next;
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		
		a.next=b;b.next=c;c.next=d;d.next=e;e.next=f;
		
		
	}
}
