package kc;

import java.util.HashMap;
import java.util.Map;

/**
    pattern = "abab", str = "redblueredblue" should return true.
    pattern = "aaaa", str = "asdasdasdasd" should return true.
    pattern = "aabb", str = "xyzabcxzyabc" should return false.
    
    "abba"
"dogcatcatdog"
 */
public class WordPatternII {
    Map<Character, String> map = new HashMap<Character, String>();
    Map<String, Character> map2 = new HashMap<String, Character>();
    
	public boolean wordPatternMatch(String pattern, String str) {
    	return helper(pattern, str);
    }
    
	private boolean helper(String pattern, String str) {
		if(str.length() == 0 && pattern.length() == 0) return true;
		if(pattern.length() == 0 || str.length() == 0) return false;
		if(pattern.length() > str.length()) return false;
		
		char current = pattern.charAt(0);
		if(map.containsKey(current)) {
			String rep = map.get(current);
			if(str.startsWith(rep)) {
				return helper(pattern.substring(1), str.substring(rep.length()));
			} else {
				return false;
			}
		} else {
			for(int i = 0 ; i < str.length() - pattern.length() + 1; i++) {
				String toRep = str.substring(0, i+1);
				if(map2.containsKey(toRep)) {
					continue;
				} else {
					map2.put(toRep, current);
				}
				map.put(current, toRep);
				if(helper(pattern.substring(1), str.substring(i+1))) return true;
				map2.remove(toRep);
				map.remove(current);
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		WordPatternII x = new WordPatternII();
		String pattern = "abba";
		String str = "dogcatcatdog";
		System.out.println(x.wordPatternMatch(pattern, str));
	}
}
