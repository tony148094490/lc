package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return helper(s,wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> helper(String s, Set<String> dict, Map<String, List<String>> map) {
    	if(map.containsKey(s)) return map.get(s);
    	
    	List<String> newRes = new ArrayList<String>();
    	if(s.length() == 0) {
    		// tricky here, need to add an empty string for distinguishing base case and negative case
    		newRes.add("");
    		return newRes;
    	}
    	
    	for(String word : dict) {
    		if(s.startsWith(word)) {
    			List<String> list = helper(s.substring(word.length()), dict, map);
    			for(String str : list) {
    				newRes.add(word + (str == "" ? "": " ") + str);
    			}
    		}
    	}
    	map.put(s, newRes);
    	return newRes;
    }   
    
    
    public static void main(String[] args) {
    	WordBreakII x = new WordBreakII();
    	String s = "abcd";
    	Set<String> set = new HashSet<String>();
    	String[] dict = {"a","abc","b","cd"};
    	for(String str: dict) set.add(str);
    	System.out.println(x.wordBreak(s, set));
	}
}
