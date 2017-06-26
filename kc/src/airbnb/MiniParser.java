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
        if(s.length() == 0) return null;
        if(Character.isDigit(s.charAt(0)) || s.charAt(0) == '-') return new NestedInteger(Integer.parseInt(s));
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger num = new NestedInteger();
        stack.push(num);
        NestedInteger res = num;
        for(int i = 0 ; i < s.length(); i++) {
            NestedInteger parent = stack.pop();
            if(Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                String cur = getNr(s, i);
                NestedInteger n = new NestedInteger(Integer.parseInt(cur));
                parent.add(n);
                stack.push(parent);
                i += cur.length() - 1;
            } else if(s.charAt(i) == ',') {
                stack.push(parent);
            } else if(s.charAt(i) == '[') {
                NestedInteger newInteger = new NestedInteger();
                stack.push(parent);
                stack.push(newInteger);
            } else if(s.charAt(i) == ']') {
                NestedInteger grandpa = stack.pop();
                grandpa.add(parent);
                stack.push(grandpa);
                res = parent;
            }
        }
        return res;
    }
    private String getNr(String s, int index) {
        int i = index;
        while(i < s.length() && (s.charAt(i) == '-' || Character.isDigit(s.charAt(i)))) i++;
        return s.substring(index, i);
    }
    
    public static void main(String[] args) {
    	MiniParser x = new MiniParser();
    	NestedInteger nested = x.deserialize("[123,[],123]");
    	System.out.println(nested);
	}
}
