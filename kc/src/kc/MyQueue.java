package kc;

import java.util.Stack;

class MyQueue {
	Stack<Integer> stackReal = new Stack<Integer>();
	Stack<Integer> stackReverse = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
        if(!stackReverse.isEmpty()){
        	while(!stackReverse.isEmpty()) {
        		stackReal.push(stackReverse.pop());
        	}
        }
        stackReal.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!stackReverse.isEmpty()) {
        	stackReverse.pop();
        } else {
        	int size = stackReal.size();
        	while(size > 1) {
        		stackReverse.push(stackReal.pop());
        		size--;
        	}
        	stackReal.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!stackReverse.isEmpty()) {
        	return stackReverse.peek();
        } else {
        	while(!stackReal.isEmpty()) {
        		stackReverse.push(stackReal.pop());
        		
        	}
        	return stackReverse.peek();
        }    
        }

    // Return whether the queue is empty.
    public boolean empty() {
        return stackReal.isEmpty() && stackReverse.isEmpty();
    }
}