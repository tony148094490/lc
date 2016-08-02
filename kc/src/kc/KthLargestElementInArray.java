package kc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
	public int findKthLargest(int[] nums, int k) {
    	
    	Comparator<Integer> comp = new Comparator<Integer>(){
    		public int compare(Integer a, Integer b) {
    			if(a > b) {
    				return -1;
    			} else if(a < b) {
    				return 1;
    			} else{
    				return 0;
    			}
    		}
    	};
    	
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, comp);
        
        for(Integer x : nums){
        	heap.offer(x);
        }
        
        while(k>1) {
        	heap.poll();
        	k--;
        }
        
        return heap.poll();
    }
}
