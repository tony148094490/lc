package kc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
    	List<String> res = new ArrayList<String>();
    	Queue<String> q = new LinkedList<String>();
    	Set<String> visited = new HashSet<String>();
    	if(s == null) return res;
    	q.add(s);
    	boolean found = false;
    	while(!q.isEmpty()) {
    		//remove characters one by one
    		String cur = q.poll();
    		if(isValid(cur)) {
    			res.add(cur);
    			found = true;
    		}
    		if(found) continue;
    		for(int i = 0 ; i < cur.length(); i++) {
    			if(cur.charAt(i) != ')' && cur.charAt(i) != '(') continue;
    			String newString = cur.substring(0, i) + cur.substring(i+1, cur.length());
    			if(!visited.contains(newString)) {
    				visited.add(newString);
    				q.add(newString);
    			}
    		}
    	}
    	return res;
    }
    
    private boolean isValid(String s) {
    	int left = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == '(') {
    			left++;
    		} else if(s.charAt(i) == ')') {
    			if(left == 0) return false;
    			left--;
    		}
    	}
    	return left == 0;
    }

    public static void main(String[] args) {
    	RemoveInvalidParentheses x = new RemoveInvalidParentheses();

    	System.out.println(x.removeInvalidParentheses("aaa()"));
    }
}
