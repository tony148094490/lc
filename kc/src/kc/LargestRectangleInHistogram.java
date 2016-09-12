package kc;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
    	if(heights.length == 0) return 0;
    	if(heights.length == 1) return heights[0];

    	Stack<Integer> stack = new Stack<Integer>();
    	int max = 0;
    	for(int i = 0 ; i < heights.length; i++) {
    		if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
    			stack.push(i);
    		} else {
    			int top = stack.pop();
    			while(heights[top] > heights[i]) {
    				//calculate the max for that particular bar
    				int right = i;
    				int left = stack.isEmpty() == true ? -1 : stack.peek();
    				max = Math.max(max, (right - left - 1) * heights[top]);
    				if(stack.isEmpty()) {
    					break;
    				}else {
    					top = stack.pop();
    				}
    			}
    			if(heights[top] <= heights[i]) stack.push(top);
    			stack.push(i);
    		}
    	}
    	
    	while(!stack.isEmpty()) {
    		int curBar = stack.pop();
    		int left = stack.isEmpty() == true ? -1 : stack.peek();
    		max = Math.max(max, heights[curBar] * (heights.length -1 - left));
    	}
    	
    	return max;
    }
    
    public static void main(String[] args) {
    	LargestRectangleInHistogram x= new LargestRectangleInHistogram();
    	int[] arr= {2,1,5,6,2,3};
    	System.out.println(x.largestRectangleArea(arr));
	}
}
