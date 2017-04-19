	package kc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head;
    Node tail;
    int cap;
    Map<Integer, Node> cache;
    
    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) return -1;
        moveToHead(head, node);
        return node.val;
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)) {
            Node n = cache.get(key);
            moveToHead(head, n);
            n.val = value;
        } else {
            if(cache.size() == cap) {
                Node tailPrev = tail.prev;
                cache.remove(tailPrev.key);
                removeNode(tailPrev);
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
            } else {
                Node newNode = new Node(key, value);
                cache.put(key,newNode);
                addToHead(newNode);
            }
        }
    }
    
    private void moveToHead(Node head, Node cur) {
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur.next = head.next;
        head.next.prev = cur;
        head.next = cur;
        cur.prev = head;
    }
    
    private void removeNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public class Node {
        Node prev;
        Node next;
        int val;
        int key;
        public Node(int k,int v) {
            val = v;
            key = k;
        }
    }
    public static void main(String[] args) {
    	LRUCache x = new LRUCache(1);
    	x.set(2, 1);
    	System.out.println(x.get(2));
	}
}
