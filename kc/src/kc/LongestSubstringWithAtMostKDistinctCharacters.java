package kc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
	/**
	 *  For example, Given s = “eceba” and k = 2,
T is "ece" which its length is 3. 
	 * @param s
	 * @param k
	 * @return
	 */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k <= 0) return 0;
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Integer, Character> positions = new HashMap<Integer, Character>();
        int max = 0, left = 0;
        for(int i = 0 ; i < s.length() ;i++) {
        	if(map.containsKey(s.charAt(i))) {
        		map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        		positions.put(i, s.charAt(i));
        	} else {
        		if(map.size() == k) {
        			for(int j = left; j < i; j++) {
        				char c = positions.get(j);
        				int list = map.get(c);
        				if(list == 1) {
        					map.remove(c);
        					left = j + 1;
        					break;
        				} else {
        					map.put(c, list - 1);
        				}
        			}
        		}
        		map.put(s.charAt(i), 1);
        		positions.put(i, s.charAt(i));
        	}
        	max = Math.max(max, i - left + 1);
        }
        return max;		
    }
    
    
    
    public static void main(String[] args) {
    	LongestSubstringWithAtMostKDistinctCharacters x = new LongestSubstringWithAtMostKDistinctCharacters();
    	String s = "eceba";
    	System.out.println(x.lengthOfLongestSubstringKDistinct(s, 2));
	}
    
}
