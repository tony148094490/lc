package kc;

import java.util.Comparator;
import java.util.PriorityQueue;


// this is O(M*N), it can be better. Pay attention in next round
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists == null || lists.length == 0) return null;
    	
    	int size = lists.length;
    	
    	Comparator<ListNode> comparator = new Comparator<ListNode>(){
    			
    			public int compare(ListNode cur, ListNode that) {
    				if(cur.val < that.val) {
    					return -1;
    				} else if(cur.val == that.val) {
    					return 0;
    				} else {
    					return 1;
    				}
    			}
    			
    	};
        
    	
    	PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(size , comparator);
    	
    	for(ListNode node : lists) {
    		if(node != null) {
    			heap.add(node);
    		}
    	}
    	ListNode res = new ListNode(-1);
    	ListNode cur = res;
    	
    	while(!heap.isEmpty()) {
    		cur.next = heap.poll();
    		cur = cur.next;
    		if(cur.next != null) {
    			heap.add(cur.next);
    		}
    		cur.next = null;
    	}
    	
    	return res.next;
    }
    
    
    public static void main(String[] args) {
    	
    }
}
