package kc;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
    	if(q1.isEmpty()) {
    		q2.add(x);
    	} else {
    		q1.add(x);
    	}
    }

    // Removes the element on top of the stack.
    public void pop() {
    	if(q1.isEmpty()) {
        	int size = q2.size();
        	while(size > 1) {
        		q1.add(q2.poll());
        		size--;
        	}
        	q2.poll();
    	} else {
        	int size = q1.size();
        	while(size > 1) {
        		q2.add(q1.poll());
        		size--;
        	}
        	q1.poll();
    	}
    }

    // Get the top element.
    public int top() {
    	int res = 0;
    	if(q1.isEmpty()) {
        	int size = q2.size();
        	while(size > 1) {
        		q1.add(q2.poll());
        		size--;
        	}
        	 res = q2.poll();
        	q1.add(res);
    	} else {
        	int size = q1.size();
        	while(size > 1) {
        		q2.add(q1.poll());
        		size--;
        	}
        	 res = q1.poll();
        	q2.add(res);
    	}
    	return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
