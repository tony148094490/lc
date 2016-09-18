package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    	List<List<String>> res = new ArrayList<List<String>>();
        if(beginWord.equals(endWord)) return res;
        wordList.add(endWord);
        wordList.remove(beginWord);
        Set<String> neighbours = new HashSet<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        neighbours.add(beginWord);
        
        while(!neighbours.isEmpty()) {
        	Set<String> overall = new HashSet<String>();
        	for(String str  : neighbours) {
        		Set<String> newNei = getNext(str, wordList);
        		overall.addAll(newNei);
        		for(String s : newNei) {
        			
        			if(map.containsKey(s)) {
        				map.get(s).add(str);
        			} else {
        				List<String> newList = new ArrayList<String>();
        				newList.add(str);
        				map.put(s, newList);
        			}
        			
        			if(s.equals(endWord)) {
        				List<String> cur = new ArrayList<String>();
        				cur.add(endWord);
        				cur.add(0, str);
            			getList(str, map, res, cur);

        			}
        		}
        	}
        	wordList.removeAll(overall);
        	if(!res.isEmpty()) break;
        	neighbours = overall;
        }
        
        return res;
    }
    
    private Set<String> getNext(String str, Set<String> set) {
    	Set<String> res = new HashSet<String>();
    	char[] chars = str.toCharArray();
    	for(int j = 0 ; j < chars.length; j++) {
	    		char c = chars[j];
    		for(char i = 'a' ; i <= 'z'; i++) {
	    		if(c == i) continue;
	    		chars[j] = i;
	    		String newStr = new String(chars);
	    		if(set.contains(newStr)) {
	    			res.add(newStr);
	    		}
	    	}
    		chars[j] = c;
    	}
    	return res;
    }
    
    // getr result
    private void getList(String str, Map<String, List<String>> map, List<List<String>> res, List<String> cur) {
    	if(!map.containsKey(str)) {
    		res.add(new ArrayList<String>(cur));
    	} else {
    		List<String> list = map.get(str);
    		for(String s : list) {
    			cur.add(0,s);
    			getList(s, map, res,cur);
    			cur.remove(0);
    		}
    	}
    }
    
    
    

    public static void main(String[] args) {
    	Set<String> wordList = new HashSet<String>();
    	wordList.add("red");
    	wordList.add("ted");
    	wordList.add("tex");
    	wordList.add("tax");
    	wordList.add("tad");
    	wordList.add("den");
    	wordList.add("rex");
    	wordList.add("pee");
    
    	Set<String> wordList2 = new HashSet<String>();
    	wordList2.add("hot");
    	wordList2.add("dot");
    	wordList2.add("dog");
    	wordList2.add("lot");
    	wordList2.add("log");
    	
    	WordLadderII x = new WordLadderII();
    	System.out.println(x.findLadders("red", "tax", wordList));
    	System.out.println(x.findLadders("hit", "cog", wordList2));
    	
    }

    
}
