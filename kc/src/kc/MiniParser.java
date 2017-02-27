package kc;

import java.util.Stack;

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
        if(s.length() == 0) return null;
        if(s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        
        Stack<NestedInteger> stack = new Stack<>();
        int l = 0;
        NestedInteger x = null;
        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) == '[') {
                if(x != null) {
                    stack.push(x);//push in parent
                }
                x = new NestedInteger();// tracking the new child
                l = i + 1;
            } else if(s.charAt(i) == ']') {
                if(l < i) x.add(new NestedInteger(Integer.parseInt(s.substring(l, i)))); //avoid [] or ]]
                if(!stack.isEmpty()) {
                    stack.peek().add(x);
                    x = stack.pop();
                }
                l = i + 1;
            } else if(s.charAt(i) == ',') {
                if(l < i) x.add(new NestedInteger(Integer.parseInt(s.substring(l,i)))); // avoid ],
                l = i + 1;
            }
        }
        return x;
    }
    
    public static void main(String[] args) {
    	MiniParser x = new MiniParser();
    	NestedInteger nested = x.deserialize("[123,[],123]");
    	System.out.println(nested);
	}
}
