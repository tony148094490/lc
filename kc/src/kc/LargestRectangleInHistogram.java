package kc;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights.length <= 0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < heights.length; i++) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                int cur = stack.pop();
                int rightEdge = i;
                while(heights[cur] > heights[i]) {
                    int left = stack.isEmpty() == true ? 0 : (stack.peek() + 1);
                    max = Math.max(max, heights[cur] * (rightEdge - left));
                    if(stack.isEmpty()) {
                        break;
                    } else {
                        cur = stack.pop();
                    }
                }
                if(heights[cur] <= heights[i]) stack.push(cur);
                stack.push(i);
            }
        }
        
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            int left = stack.isEmpty() == true ? 0 : (stack.peek() + 1);
            max = Math.max(max, heights[cur] * (heights.length - left));
        }
        return max;
    }
    
    public static void main(String[] args) {
    	LargestRectangleInHistogram x= new LargestRectangleInHistogram();
    	int[] arr= {2,1,5,6,2,3};
    	System.out.println(x.largestRectangleArea(arr));
	}
}
