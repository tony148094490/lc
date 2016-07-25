package kc;

import java.util.Stack;

public class MinStack {
 
	Stack<Integer> stack;
	Stack<Integer> minStack;
	
	public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x) {
        	minStack.push(x);
        }
    }
    
    public void pop() {
        int pop = stack.pop();
        if(pop == minStack.peek()) minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
    	if(minStack.isEmpty()) return Integer.MIN_VALUE;
        return minStack.peek();
    }
	
	public static void main(String[] args) {
		
	}
}

