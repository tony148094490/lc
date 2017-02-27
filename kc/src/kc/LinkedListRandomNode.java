package kc;

import java.util.Random;

public class LinkedListRandomNode {
    ListNode root;
    Random rand = new Random();
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public LinkedListRandomNode(ListNode head) {
        root = head;
	}
    /** Returns a random node's value. */
    public int getRandom() {
        if(root == null) return -1;
        ListNode pointer = root;
        int counter = 0;
        int res = 0;
        while(pointer != null) {
            int random = rand.nextInt(counter+1);
            if(counter == random) {
                res = pointer.val;
            }
            counter++;
            pointer = pointer.next;
        }
        return res;
    }
}
