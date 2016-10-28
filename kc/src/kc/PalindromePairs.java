package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for(int i = 0; i < words.length; i++) {
    		if(words[i].equals("")) {
    			for(int j = 0; j < words.length; j++) {
    				if(i == j || !isPalin(words[j])) continue;
    				res.add(Arrays.asList(i,j));
    				res.add(Arrays.asList(j,i));
    			}
    		} else {
    			map.put(words[i], i);
    		}
    	}
    	
    	for(int i = 0 ; i < words.length; i++) {
    		if(words[i].equals("")) continue;
    		String rev = reverse(words[i]);
    		if(map.containsKey(rev) && map.get(rev) != i) {
    			res.add(Arrays.asList(i,map.get(rev)));
    		}
    	}
    	
    	for(int j = 0; j < words.length; j++) {
    		String str = words[j];
    		for(int i = 1; i < str.length(); i++) {
    			String firstHalf = str.substring(0, i);
    			String secondHalf = str.substring(i);
    			String firstHalfRev = reverse(firstHalf);
    			String secondHalfRev = reverse(secondHalf);
    			if(isPalin(secondHalf) && map.containsKey(firstHalfRev)) res.add(Arrays.asList(j, map.get(firstHalfRev)));
    			if(isPalin(firstHalf) && map.containsKey(secondHalfRev)) res.add(Arrays.asList(map.get(secondHalfRev), j));    			
    		}
    	}
    	return res;
    }
    private String reverse(String a) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = a.length() - 1 ; i >= 0; i--) {
    		sb.append(a.charAt(i));
    	}
    	return sb.toString();
    }
    private boolean isPalin(String a) {
    	int i = 0;
    	int j = a.length() - 1;
    	while(i < j) {
    		if(a.charAt(i) != a.charAt(j)) return false;
    		i++;
    		j--;
    	}
    	return true;
    }

    public static void main(String[] args) {
    	PalindromePairs x = new PalindromePairs();
    	String[] arr = {"abcd", "dcba", "lls", "s", "sssll"};
    	System.out.println(x.palindromePairs(arr));
    }
}
