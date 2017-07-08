package airbnb;

import java.util.Stack;

import kc.NestedInteger;

/**
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if(s.isEmpty()) return null;
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(new NestedInteger());
        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            NestedInteger parent = stack.pop();
            if(Character.isDigit(c) || c == '-') {
                String nr = getNr(s, i);
                NestedInteger number = new NestedInteger(Integer.parseInt(nr));
                parent.add(number);
                stack.push(parent);
                i += nr.length() - 1;
            } else if(c == ',') {
                stack.push(parent);
            } else if(c == '[') {
                stack.push(parent);
                stack.push(new NestedInteger());
            } else if(c == ']') {
                NestedInteger grandpa = stack.pop();
                grandpa.add(parent);
                stack.push(grandpa);
            } else {
                return null;   
            }
        }
        
        return stack.pop().getList().get(0);
    }
    
    private String getNr(String s, int i) {
        int start = i;
        while(i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-')) i++;
        return s.substring(start, i);
    }
    
    public static void main(String[] args) {
    	MiniParser x = new MiniParser();
    	NestedInteger nested = x.deserialize("[123,[],123]");
    	System.out.println(nested);
	}
}
