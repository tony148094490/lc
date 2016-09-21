package kc;
/**
 * Sort a linked list using insertion sort.
 * @author zhaowz
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode cur = head;
        while(cur != null) {
        	ListNode next = cur.next;
        	insert(res, cur);
        	cur = next;
        }
        return res.next;
    }
    private void insert(ListNode res, ListNode node) {
    	ListNode first = res;
    	ListNode second = res.next;
    	while(second != null && second.val <= node.val) {
    		first = first.next;
    		second = second.next;
    	}
    	first.next = node;
    	node.next = second;
    }
    
    public static void main(String[] args) {
    	InsertionSortList x = new InsertionSortList();
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(2);
    	ListNode d = new ListNode(-3);
    	ListNode e = new ListNode(4);
    	ListNode f = new ListNode(0);
    	ListNode g = new ListNode(5);
    	a.next=b;b.next=c;//c.next=d;d.next=e;e.next=f;f.next=g;
    	System.out.println(x.insertionSortList(a));
    }
}
