package kc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/**
 *  You are given a string, s, and a list of words, words, 
 *  that are all of the same length. Find all starting indices
 *   of substring(s) in s that is a concatenation of each word 
 *   in words exactly once and without any intervening characters.
For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter). 
 */
public class SubstringOfCacatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(words.length < 1 || s.length() < words[0].length() * words.length) return res;
        
        Map<String, Integer> counts = new HashMap<String, Integer>();
            	
        for(String str : words) {
        	if(counts.containsKey(str)) {
        		counts.put(str, counts.get(str) + 1);
        	} else {
        		counts.put(str, 1);
        	}
        }
        
        int step = words[0].length();
        int fullLength = words[0].length() * words.length;
        int start = -1;
        int end = -1;
        
        for(int j = 0; j < step; j++){
        	start = -1;
        	Map<String, Queue<Integer>> newMap = new HashMap<String, Queue<Integer>>();
	        for(int i = j ; i + step <= s.length() ; i+=step) {
	        	String curString = s.substring(i, i+step);
	        	if(counts.containsKey(curString)) {
	        		if(!newMap.containsKey(curString)) newMap.put(curString, new LinkedList<Integer>());
	        		if(newMap.get(curString).size() < counts.get(curString)) {
	        			newMap.get(curString).add(i);
	        			if(start == -1) {
	        				start = i;
	        			}
	        			end = i + step;
	        		} else {
	        			if(start == -1) {
	        				start = i;
	        				newMap.get(curString).poll();
	        			} else {
	            			int last = newMap.get(curString).poll();
	            			if (last >= start) {
	            				start = last + step;
	            			}
	        			}
	        			newMap.get(curString).add(i);
	        			end = i + step;
	        		}
	        		
	        		//evaluate
	    			if(end - start == fullLength) {
	    				res.add(start);
	    			}
	        	} else {
	        		start = -1;
	        		end = -1;
	        	}
	        }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	SubstringOfCacatenationOfAllWords x = new SubstringOfCacatenationOfAllWords();
//    	String s = "barfoothefoobarman";
//    	String[] words =  {"foo", "bar"};
//    	System.out.println(x.findSubstring(s, words));
//    	
//    	String ss = "wordgoodgoodgoodbestword";
//    	String[] words2 = {"word","good","best","good"};
//    	System.out.println(x.findSubstring(ss, words2));
//
//    	String sss = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
//    	String[] words3 = {"fooo","barr","wing","ding","wing"};
//    	System.out.println(x.findSubstring(sss, words3));
    	
    	String ssss = "aaaaaaaa";
    	String[] words4 = {"aa","aa","aa"};
    	System.out.println(x.findSubstring(ssss, words4));
	}
}
