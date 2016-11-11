package kc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        if(words.length == 0) return "";
        if(words.length == 1) return words[0];
        
    	//dependency list
    	Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
    	for(int i = 0 ; i < words[0].length(); i++) {
    		if(!map.containsKey(words[0].charAt(i))) {
    			Set<Character> set = new HashSet<Character>();
    			map.put(words[0].charAt(i), set);
    		}
    	}
    	
        for(int i = 1 ; i < words.length; i++) {
        	String str = words[i];
        	String last = words[i-1];
        	
        	// take care of prefix cases where 'wrta' 'wrt' is invalid
        	if(str.length() < last.length() && last.startsWith(str)) return "";
        	
        	boolean found = false;
        	for(int j = 0 ; j < str.length(); j++) {
        		if(!map.containsKey(str.charAt(j))) {
        			Set<Character> set = new HashSet<Character>();
        			map.put(str.charAt(j), set);
        		}
        		
        		if(!found && j < last.length() && str.charAt(j) != last.charAt(j)) {
        			map.get(last.charAt(j)).add(str.charAt(j));
        			found = true;
        		}
        		
        	}
        }
        
        //topological sort starts
        Set<Character> overall = new HashSet<Character>();
    	Stack<Character> stack = new Stack<Character>();
    	boolean result = true;
        for(Character c : map.keySet()) {
        	if(overall.contains(c)) { 
        		continue;
        	}
        	result &= dfs(map, c, overall, stack, new HashSet<Character>());
        	if(!result) return "";
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
        	sb.append(stack.pop());
        }
        return sb.toString();
    }
    
    private boolean dfs(Map<Character, Set<Character>> map, char current, Set<Character> overall, Stack<Character> stack,
    		Set<Character> visited) {
    	
    	if(visited.contains(current)) { 
    		return false;
    	}
    	visited.add(current);
    	Set<Character> set = map.get(current);
    	boolean result = true;
    	for(Character c : set) {
    		result &= dfs(map, c, overall, stack, visited);
    		if(!result) return false;
    	}
    	visited.remove(current);
    	
    	if(!overall.contains(current)){
    		stack.push(current);
    		overall.add(current);
    	}
    	
    	return true;
    }
    
    public static void main(String[] args) {
    	AlienDictionary x = new AlienDictionary();
    	String[] arr = {  "wrt",
    			  "wrf",
    			  "er",
    			  "ett",
    			  "rftt"};
    	System.out.println(x.alienOrder(arr));
	}
}
