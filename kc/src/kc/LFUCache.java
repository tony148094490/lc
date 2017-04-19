package kc;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    Node front;
    Node end;
    
    Map<Integer, Node> heads = new HashMap<>();
    Map<Integer, Node> tails = new HashMap<>();
    Map<Integer, Node> map = new HashMap<>();
    
    int max;
    
    public LFUCache(int capacity) {
        front = new Node(-1, -1);
        end = new Node(-1, -1);
        front.nextFreq = end;
        end.prevFreq = front;
        
        max = capacity;
    }
    
    public int get(int key) {
        if(max == 0) return -1;
        if(!map.containsKey(key)) return -1;
        Node res = map.get(key);
        
        Node prevHead = heads.get(res.freq);
    
        res.prev.next = res.next;
        res.next.prev = res.prev;
       
        res.freq++;
        
        Node head = heads.get(res.freq);
        Node tail = tails.get(res.freq);
        if(head == null) {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            heads.put(res.freq, head);
            tails.put(res.freq, tail);
            head.next = res;
            res.prev = head;
            tail.prev = res;
            res.next = tail;
        } else {
            head.next.prev = res;
            res.next = head.next;
            head.next = res;
            res.prev = head;
        }
        
        if(prevHead.next.val == -1) {
            prevHead.prevFreq.nextFreq = head;
            head.prevFreq = prevHead.prevFreq;
            
            head.nextFreq = prevHead.nextFreq;
            prevHead.nextFreq.prevFreq = head;
            heads.remove(res.freq-1);
            tails.remove(res.freq-1);
        } else {
        	prevHead.prevFreq.nextFreq = head;
        	head.prevFreq = prevHead.prevFreq;
        	head.nextFreq = prevHead;
        	prevHead.prevFreq = head;
        }
        
        return res.val;
    }
    
    public void put(int key, int value) {
        if(max == 0) return;
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            get(key);
        } else {
            if(map.size() == max) {
                Node head = end.prevFreq;
                Node tail = tails.get(head.next.freq);
                Node toRemove = tail.prev;
                if(toRemove.prev.val == -1) {
                    toRemove.prev.prevFreq.nextFreq = end;
                    end.prevFreq = toRemove.prev.prevFreq;
                    heads.remove(toRemove.freq);
                    tails.remove(toRemove.freq);
                } else {
                    toRemove.prev.next = toRemove.next;
                    toRemove.next.prev = toRemove.prev;
                }
                map.remove(toRemove.key);
                
            }
            Node node = new Node(key, value);
            map.put(key,node);
            node.freq = 1;
            if(heads.containsKey(node.freq)) {
                Node head = heads.get(node.freq);
                head.next.prev = node;
                node.next = head.next;
                head.next = node;
                node.prev= head;
            } else {
                Node head = new Node(-1, -1);
                Node tail = new Node(-1, -1);
                heads.put(1, head);
                tails.put(1, tail);
                head.next = node;
                node.prev = head;
                node.next = tail;
                tail.prev = node;
                end.prevFreq.nextFreq = head;
                head.prevFreq = end.prevFreq;
                head.nextFreq = end;
                end.prevFreq = head;
            }
        }
    }
    
    class Node {
        int key;
        int val;
        int freq;
        Node next = null;
        Node prev = null;
        Node nextFreq = null;
        Node prevFreq = null;
        
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }
    
    public static void main(String[] args) {
    	LFUCache x = new LFUCache(2);
    	x.put(1, 1);
    	x.put(2, 2);
    	System.out.println(x.get(1));
    	x.put(3, 3);
    	System.out.println(x.get(2));
    	System.out.println(x.get(3));
    	x.put(4, 4);
    	System.out.println(x.get(1));

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

