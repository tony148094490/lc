package kc;

import java.util.HashMap;
import java.util.Map;

public class CopyListWIthRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
    	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode res = new RandomListNode(head.label);
        RandomListNode old = head;
        RandomListNode newNode = res;
        map.put(head, res);
        while(old != null) {
        	if(old.next != null) {
        		RandomListNode next = new RandomListNode(old.next.label);
        		newNode.next = next;
        		map.put(old.next, next);
        	}
        	old = old.next;
        	newNode = newNode.next;
        }
        newNode = res;
        while(head != null) {
        	RandomListNode random = head.random;
        	if(random != null) {
        		newNode.random = map.get(random);
        	}
        	head = head.next;
        	newNode = newNode.next;
        }
        
        return res;
    }
}
