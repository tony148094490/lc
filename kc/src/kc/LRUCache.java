package kc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    DLNode head;
    DLNode tail;
    
    Map<Integer, DLNode> cache;
    int cap;
    
    public LRUCache(int capacity) {
        head = new DLNode(-1, -1);
        tail = new DLNode(-1, -2);
        head.next = tail;
        tail.pre = head;
        cache = new HashMap<Integer, DLNode>();
        cap = capacity;
    }
    
    public int get(int key) {
        DLNode node = cache.get(key);
        if(node == null) return -1;
        
        moveToHead(node, head);
        return node.value;
    }
    
    public void set(int key, int value) {
        DLNode node = cache.get(key);
        if(node == null) {
    		node = new DLNode(key, value);
        	if(cache.size() == cap) {
        		DLNode tailToRemove = removeTail(tail);
        		addNode(node, head);
        		cache.remove(tailToRemove.key);
        		cache.put(key, node);
        	} else {
        		addNode(node, head);
        		cache.put(key, node);
        	}
        } else {
        	node.value = value;
        	moveToHead(node, head);
        }
    }
    
	public void addNode(DLNode n, DLNode head) {
		DLNode prevHead = head.next;
		prevHead.pre = n;
		n.pre = head;
		head.next = n;
		n.next = prevHead;
	}
	
	public void removeNode(DLNode n) {
		n.pre.next = n.next;
		n.next.pre = n.pre;
	}
	
	public DLNode removeTail(DLNode tail) {
		DLNode pre = tail.pre;
		pre.pre.next = tail;
		tail.pre = pre.pre;
		return pre;
	}
	
	public void moveToHead(DLNode n, DLNode head) {
		removeNode(n);
		addNode(n, head);
	}
    
    private class DLNode {
    	int key;
    	int value;
    	DLNode pre = null;
    	DLNode next = null;
    	
    	public DLNode(int k, int v) {
    		key = k;
    		value = v;
    	}
    }
    
    public static void main(String[] args) {
    	LRUCache x = new LRUCache(1);
    	x.set(2, 1);
    	System.out.println(x.get(2));
	}
}
