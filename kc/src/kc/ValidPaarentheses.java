package kc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidPaarentheses {
    public boolean isValid(String s) {
    	if(s == null || s.length() == 0) return false;
    	Map<Character, Character> map = new HashMap<Character, Character>();
    	map.put('(',')');
    	map.put('[',']');
    	map.put('{','}');
    	
    	Stack<Character> stack = new Stack<Character>();
    	
    	for(Character c : s.toCharArray()) {
    		if(map.containsKey(c)) {
    			stack.push(c);
    		} else {
    			if(stack.isEmpty()) return false;
    			Character popped = stack.pop();
    			if(map.get(popped) != c) {
    				return false;
    			}
    		}
    		
    	}
		return stack.isEmpty();
    }
    
    
    public static void main(String[] args) {
    	ValidPaarentheses v = new ValidPaarentheses();
    	System.out.println(v.isValid("([)]"));
    	
    }
}
