package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> res = new ArrayList<List<String>>();
        if(strs.length == 0) return res;
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs) {
        	char[] arr = str.toCharArray();
        	Arrays.sort(arr);
        	String sortedStr = new String(arr);

        	if(map.containsKey(sortedStr)) {
        		map.get(sortedStr).add(str);
        	} else {
        		List<String> newList = new ArrayList<String>();
        		newList.add(str);
        		map.put(sortedStr, newList);
        	}
        }
        
        for(String s: map.keySet()) {
        	res.add(map.get(s));
        }
        
        return res;
    }
    
	
	public static void main(String[] args) {
		GroupAnagrams a = new GroupAnagrams();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = a.groupAnagrams(strs);
		for(List<String> list :res ){
			System.out.println(list);
		}
	}
}
