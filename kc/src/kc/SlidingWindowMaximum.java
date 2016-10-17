package kc;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

    	int[] res = new int[nums.length - k + 1];
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	for(int i = 0 ; i < nums.length; i++) {
    		while(!queue.isEmpty() && queue.peekFirst() < (i - k + 1)) {
    			queue.pollFirst();
    		}
    		while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
    			queue.pollLast();
    		}
    		queue.add(i);
    		if(i >= k - 1) {
    			res[i - k + 1] = nums[queue.peekFirst()];
    		}
    		
    	}
    	return res;
    }
}
