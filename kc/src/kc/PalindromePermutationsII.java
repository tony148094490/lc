package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PalindromePermutationsII {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    Character mid = null;
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        if(s.length() == 1) {
        	res.add(s);
        	return res;
        }
        if(!canPermutePalindrome(s)) return res;
        helper("", res, s);
        return res;
    }
    
    private void helper(String cur, List<String> res, String str) {
    	if(str.length() % 2 == 0 && cur.length() == str.length() / 2) {
    		StringBuilder newString = new StringBuilder();
    		newString.append(cur);
    		newString.append(reverse(cur));
    		res.add(newString.toString());
    	} else if(str.length() % 2 == 1 && cur.length() == str.length() / 2) {
    		StringBuilder newString = new StringBuilder();
    		newString.append(cur.toString());
    		newString.append(mid);
    		newString.append(reverse(cur));
    		res.add(newString.toString());
        } else {
    		for(Entry<Character, Integer> entry : map.entrySet()) {
    			char key = entry.getKey();
    			int value = entry.getValue();
    			if (value > 1) {
    				map.put(key, value - 2);    				
    				helper(cur + key,res,str);
        			map.put(key, value);
    			}
    		}
    	}
    }
    
    private String reverse(String s) {
    	StringBuilder sb = new StringBuilder();
    	return sb.append(s).reverse().toString();
    }
    
    private boolean canPermutePalindrome(String s) {
        int single = 0;
        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                single++;
                map.put(c,1);
            } else {
                if(map.get(c) % 2 == 0) {
                    single++;
                } else {
                    single--;
                }
                map.put(c, map.get(c)+1);
            }
        }
        
        for(Entry<Character, Integer> entry : map.entrySet()) {
        	if(entry.getValue() % 2 == 1) {
        		mid = entry.getKey();
            	break;
        	}
        }
        
        return (single == 0)||(single == 1 && s.length() % 2 == 1);
    }
    
    public static void main(String[] args) {
    	PalindromePermutationsII x = new PalindromePermutationsII();
    	System.out.println(x.generatePalindromes("aabbcc"));
    	System.out.println(x.map);

    	System.out.println(x.mid);
	}
}
