package kc;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        if(node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
