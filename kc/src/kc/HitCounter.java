package kc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HitCounter {
	Map<Integer, Integer> hits = new HashMap<Integer, Integer>();
	LinkedList<Integer> timestamps = new LinkedList<Integer>();
	/** Initialize your data structure here. */
    public HitCounter() {
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
    	
    	while(!timestamps.isEmpty() && timestamps.peekFirst() <= (timestamp - 300)) {
    		hits.remove(timestamps.poll());
    	}
    	
        if(hits.containsKey(timestamp)) {
        	hits.put(timestamp, hits.get(timestamp)+1);
        } else {
        	hits.put(timestamp, 1);
        }
        
        if(timestamps.isEmpty() || timestamps.peekLast() < timestamp) timestamps.add(timestamp);

    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	while(!timestamps.isEmpty() && timestamps.peekFirst() <= (timestamp - 300)) {
    		hits.remove(timestamps.poll());
    	}
    	int res = 0;
    	for(int x : hits.values()) res += x;
    	return res;
    }
    
    public static void main(String[] args) {
    	HitCounter x = new HitCounter();
    	x.hit(1);
    	x.hit(2);
    	x.hit(3);
    	System.out.println(x.getHits(4));
    	x.hit(300);
    	System.out.println(x.getHits(300));
    	System.out.println(x.getHits(301));
    	
    	
	}
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
