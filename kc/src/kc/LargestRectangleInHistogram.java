package kc;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights.length < 1) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        stack.push(0);
        for(int i = 1; i < heights.length; i++) {
            if(heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                max = Math.max(max, heights[i]);
                continue;
            }
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int index = stack.pop();
                int left = stack.size() == 0 ? 0 : stack.peek() + 1;
                max = Math.max(max, (i - left) * heights[index]); 
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            int left = stack.size() == 0 ? 0 : stack.peek() + 1;
            max = Math.max((heights.length - left) * heights[index], max);    
        }
        return max;
    }
    
    public static void main(String[] args) {
    	LargestRectangleInHistogram x= new LargestRectangleInHistogram();
    	int[] arr= {2,1,5,6,2,3};
    	System.out.println(x.largestRectangleArea(arr));
	}
}
