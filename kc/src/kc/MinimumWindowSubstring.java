package kc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        Map<Character, Queue<Integer>> indices = new HashMap<Character, Queue<Integer>>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> ref = new HashMap<Character, Integer>();
        for(Character x : t.toCharArray()) {
        	if(map.containsKey(x)) {
        		map.put(x, map.get(x) + 1);
        		ref.put(x, ref.get(x) + 1);
        	} else {
        		map.put(x,1);
        		ref.put(x,1);
        	}
        }
        String res = "";
        int maxLen = s.length() + 1;
        int start = -1;
        for(int i = 0 ; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if(ref.containsKey(c)) {
        		if(start == -1) {
        			start = i;
        		}
        		if(map.containsKey(c)) {
        			if(indices.containsKey(c)) {
        				indices.get(c).add(i);
        			} else {
        				Queue<Integer> q = new LinkedList<Integer>();
        				q.add(i);
        				indices.put(c, q);
        			}
        			
        			if(map.get(c) == 1) {
        				map.remove(c);
        			} else {
        				map.put(c,map.get(c)-1);
        			}
        			
        			if(map.isEmpty()) {
        				
        				// getMax
        				if(i - start + 1 < maxLen) {
        					maxLen = i - start + 1;
        					res = s.substring(start, i+1);
        				}
        			}
        		}
        		else {
        			int last = indices.get(c).poll();
        			if(last == start) {
        				start++;
        				while(start < i){
        					char cur = s.charAt(start);
        					if(ref.containsKey(cur)) {
        						int index = indices.get(cur).peek();
        						if(start == index) {
        							break;
        						}
        					}
        					start++;
        				}   				
        				map.put(c, 1);    				
        				i--;
        			} else {
            			indices.get(c).add(i);
        			}
        		}
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
    	MinimumWindowSubstring x = new MinimumWindowSubstring();
    	String s = "ADOBECODEBANC";
    	String t = "ABC";
    	String ss = "caae";
    	String tt = "cae";
    	String sss = "abbbacab";
    	String ttt = "abc";
    	
    	String ssss = "abcabdebac";
    	String tttt = "cea";
    	
    	System.out.println(x.minWindow(s, t));
    	System.out.println(x.minWindow(ss, tt));
    	System.out.println(x.minWindow(sss, ttt));
    	System.out.println(x.minWindow(ssss, tttt));

	}
}
