package kc;

import java.util.Stack;

/**
 * Given a string containing just the characters
 *  '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
 */
public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        int[] map = new int[s.length()];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length() ; i++) {
        	if(s.charAt(i) == '(') {
        		stack.push(i);
        	} else {
        		if(!stack.isEmpty()) {
        			int left = stack.pop();
        			map[i] = 1;
        			map[left] = 1;
        		}
        	}
        }
        
        int max = 0;
        int cur = 0;
        for(int i = 0; i < map.length; i++) {
        	if(map[i] == 1) {
        		cur++;
        	} else {
        		max = Math.max(max, cur);
        		cur = 0;
        	}
        }
        
        max = Math.max(max,cur);
    	return max;
    }
    
    public int longestValidParenthesesDP(String s) {
    	int lefts = 0;
    	int[] dp = new int[s.length()];
    	int max = 0;
    	for(int i = 0 ; i < s.length() ;i++) {
    		if(s.charAt(i) == '(') {
    			lefts++;
    		} else if(lefts > 0) {
    			dp[i] = dp[i-1] + 2;
    			if(i - dp[i] >= 0) {
    				dp[i] += dp[i-dp[i]];
    			}
    			lefts--;
        		max = Math.max(max, dp[i]);
    		}
    	}
    	return max;
    }
    
    public static void main(String[] args) {
    	LongestValidParenthesis x = new LongestValidParenthesis();
    	System.out.println(x.longestValidParentheses("()()(()"));
    	System.out.println(x.longestValidParentheses("(()()"));
	}
}
