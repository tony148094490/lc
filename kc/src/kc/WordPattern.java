package kc;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Map<String, Character> map1 = new HashMap<String, Character>();
        
        String[] arr = str.split(" ");
        if(arr.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++) {
            if(i == arr.length) return false;
            Character x = pattern.charAt(i);
            String strs = arr[i];
            if(map.containsKey(x) && map1.containsKey(strs)) {
                if(x != map1.get(strs) || !strs.equals(map.get(x))) {
                    return false;
                }
            } else if(!map.containsKey(x) && !map1.containsKey(strs)) {
                map.put(x, strs);
                map1.put(strs, x);
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
		WordPattern x = new WordPattern();
		System.out.println(x.wordPattern("abba", "dog cat cat dog"));
	}
}
