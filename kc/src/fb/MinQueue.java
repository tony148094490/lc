package fb;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
#Min Queue
//Use queue to save the minimum number
// Every time add a new number, traverse the queue, remove the number 
// bigger than it, so in the deque there will leave the numbers that smaller than it
// add this number to the end of the deque
// by doing this, the minimum number will always at the head of the deque
'Time complexity of offer : O(len), space complexity: O(n)'
 */
public class MinQueue {
	
	private Queue<Integer> q = new LinkedList<>();
	private LinkedList<Integer> min = new LinkedList<>();
	
	public void offer(int val) {
		q.offer(val);
		while(!min.isEmpty() && min.peekLast() > val) {
			min.pollLast();
		}
		min.offer(val);
	}
	
	public int poll() {
		int res = q.poll();
		if(res == min.peek()) min.poll();
		return res;
	}
	
	public int getMin() {
		return min.peek();
	}
}
