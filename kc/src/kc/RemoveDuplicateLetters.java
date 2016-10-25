package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        for(int i = 0 ; i < s.length(); i++) {
        	if(map.containsKey(s.charAt(i))) {
        		map.get(s.charAt(i)).add(i);
        	} else {
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		map.put(s.charAt(i), list);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        int size = map.size();
        for(int i = 0 ; i < size; i++) {
        	sb.append(getSmallest(map));
        }
        return sb.toString();
    }
    
    private Character getSmallest(Map<Character, List<Integer>> map) {
    	for(char c = 'a'; c <= 'z'; c++) {
    		if(!map.containsKey(c)) continue;
    		if(isValid(c, map)) {
    			map.remove(c);
    			return c;
    		}
    	}
    	return null;
    }
    
    private boolean isValid(Character c, Map<Character, List<Integer>> map) {
    	int min = map.get(c).get(0);
    	
    	for(Entry<Character, List<Integer>> entry : map.entrySet()) {
    		if(entry.getKey() == c) continue;
    		List<Integer> list = entry.getValue();
    		if(min > list.get(list.size()-1)) return false;
    	}
    	
    	for(Entry<Character, List<Integer>> entry : map.entrySet()) {
    		if(entry.getKey() == c) continue;
    		List<Integer> list = entry.getValue();
    		while(list.get(0) < min) list.remove(0);
    	}
    	
    	
    	return true;
    }
    
    public static void main(String[] args) {
    	RemoveDuplicateLetters x = new RemoveDuplicateLetters();
    	System.out.println(x.removeDuplicateLetters("bcabc"));
    	System.out.println(x.removeDuplicateLetters("cbacdcbc"));
    	System.out.println(x.removeDuplicateLetters("ccacbaba"));
    	System.out.println(x.removeDuplicateLetters("cddacd"));
    	System.out.println(x.removeDuplicateLetters("abacb"));
    	System.out.println(x.removeDuplicateLetters("rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws"));
    	System.out.println(x.removeDuplicateLetters("bxshkpdwcsjdbikywvioxrypfzfbppydfilfxxtouzzjxaymjpmdoevv"));
    	
    	
    }
}
