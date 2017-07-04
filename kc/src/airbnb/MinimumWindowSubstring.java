package airbnb;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        Map<Character, Integer> ref = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            Integer count = map.get(c);
            if(count == null) {
                count = 1;
            } else {
                count = count + 1;
            }
            map.put(c, count);
            ref.put(c, count);
        }
        
        int maxLen = s.length() + 1;
        String str = "";
        int start = -1;
        
        Map<Character, LinkedList<Integer>> window = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(ref.containsKey(c)) {
                if(start == -1) {
                    start = i;
                }    
                if(map.containsKey(c)) {
                    LinkedList<Integer> list = window.get(c);
                    if(list == null) {list = new LinkedList<>(); window.put(c, list);}
                    list.add(i);
                    Integer count = map.get(c);
                    if(count == 1) {
                        map.remove(c);
                    } else {
                        map.put(c, count - 1);
                    }
                    if(map.isEmpty()) {
                        if(maxLen > i - start + 1) {
                            str = s.substring(start, i+1);
                            maxLen = i - start + 1;
                        }
                    }
                } else {
                    int last = window.get(c).poll();
                    if(start == last) {
                        start++;
                        while(start < i) {
                            if(ref.containsKey(s.charAt(start)) && window.get(s.charAt(start)).peek() == start) {
                                break;
                            }
                            start++;
                        } 
                        i--;
                        map.put(c, 1);
                    } else {
                        window.get(c).add(i);
                    }
                } 
                
            }
        }
        return str;
    }
    
    public String minWindow2(String s, String t) {
        int[] cnt = new int[256];//char 有256个数
        for (char c : t.toCharArray()) cnt[c]++;
        
        int min = Integer.MAX_VALUE, from = 0, total = t.length();
        for (int i = 0, j = 0; i < s.length(); i++) {
        	cnt[s.charAt(i)]--;
            if (cnt[s.charAt(i)] >= 0) total--;
            while (total == 0) {                    // total=0 means valid window
                if (i - j + 1 < min) {//try to update the min length
                    min = i - j + 1;
                    from = j;
                }
                
                cnt[s.charAt(j)]++;
                if(cnt[s.charAt(j)] > 0) {
                	total++;
                }
                
                j++;

            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
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
    	System.out.println();
    	System.out.println(x.minWindow2(s, t));
    	System.out.println(x.minWindow2(ss, tt));
    	System.out.println(x.minWindow2(sss, ttt));
    	System.out.println(x.minWindow2(ssss, tttt));
	}
}
