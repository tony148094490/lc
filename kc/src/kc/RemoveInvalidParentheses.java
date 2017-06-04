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
    
    public List<String> removeInvalidParentheses2(String s) {
        List<String> res = new ArrayList<>();
        if(isValid(s)) {
            res.add(s);
            return res;
        }
        Set<String> dedupe = new HashSet<>();

        LinkedList<String> parents = new LinkedList<>();
        LinkedList<String> children = new LinkedList<>();
        parents.add(s);
        boolean found = false;
        while(!parents.isEmpty()) {
            String parent = parents.poll();
            for(int i = 0 ; i < parent.length(); i++) {
                String child = parent.substring(0,i) + parent.substring(i+1);
                if(isValid2(child)) {
                    found = true;
                    if(!dedupe.contains(child)) {
                        dedupe.add(child);
                        res.add(child);   
                    }
                } else {
                    children.add(child);   
                }
            }
            
            if(parents.isEmpty()) {
                if(found) {
                    return res;
                }
                parents = children;
                children = new LinkedList<>();
            }
        }
        
        // no valid options
        return res;
    }
    private boolean isValid2(String s) {
        int left = 0;
        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            } else if(s.charAt(i) == ')'){
                left--;
            }
            if(left < 0) return false;
        }
        return left == 0;
    }
    
    private String remove(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	int extraLeft = 0;
    	int extraRight = 0;
    	int index = 0;
    	while(index < sb.length()) {
    		if(sb.charAt(index) == '(') {
    			extraLeft++;
    		} else if(sb.charAt(index) == ')') {
    			if(extraLeft > 0) {
    				extraLeft--;
    			} else {
    				extraRight++;
    			}
    		}
    		index++;
    	}
    	
    	index = 0;
    	while(extraRight > 0 && index < sb.length()) {
    		if(sb.charAt(index) == ')') {
    			sb.deleteCharAt(index);
    			extraRight--;
    		}
    		index++;
    	}
    	
    	index = sb.length()-1;
    	while(extraLeft > 0 && index >= 0) {
    		if(sb.charAt(index) == '(') {
    			sb.deleteCharAt(index);
    		}
    		index--;
    	}
    	return sb.toString();
    }

    public static void main(String[] args) {
    	RemoveInvalidParentheses x = new RemoveInvalidParentheses();

    	System.out.println(x.removeInvalidParentheses2("()(((((((()"));
    }
}
