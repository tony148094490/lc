package kc;
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
        NestedInteger root = new NestedInteger();
        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) == '[') {
            	if(s.charAt(i+1) == ']') return root;
            	NestedInteger next = deserialize(s.substring(i+1));
            	i = moveToNext(s, i+1);
            	root.add(next);
            } else if(s.charAt(i) == ']') {
            	return root;
            } else if(s.charAt(i) == ',') {
            	NestedInteger next = deserialize(s.substring(i+1));
            	i++;
            	i = moveToNext(s, i);
            	root.add(next);
            } else {
            	Integer n = getInteger(s, i);
            	root.setInteger(n);
            	return root;
            }
        }
        return root;
    }
    
    private Integer getInteger(String s, int c) {
    	int sign = 1;
    	if(s.charAt(0) == '-') {
    		sign = -1;
    		c++;
    	}
    	int i = c;
    	for(i = c; i < s.length(); i++) {
    		if(s.charAt(i) > '9' || s.charAt(i) < '0') break;
    	}
    	int number = Integer.parseInt(s.substring(c, i));
    	return number * sign;
    }
    
    private int moveToNext(String s, int c) {
    	if(s.charAt(c) != '[') {
    		while(s.charAt(c) != '[' && s.charAt(c) != ']' && s.charAt(c) != ',') {
    			c++;
    		}
    		return c - 1;
    	}
    	
    	int left = 0;
    	for(int i = c; i < s.length() ;i++) {
    		if(s.charAt(i) == '[') {
    			left++;
    		}else if(s.charAt(i) == ']') {
    			left--;
    		}
    		if(left == 0) return i;
    	}
    	return -1;
    }
    
    public static void main(String[] args) {
    	MiniParser x = new MiniParser();
    	NestedInteger nested = x.deserialize("[123,[],123]");
    	System.out.println(nested);
	}
}
