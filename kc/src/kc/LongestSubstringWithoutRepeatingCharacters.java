package kc;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
 
	//Time: O(n). Space: O(n)
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> positionOfChar = new HashMap<Character,Integer>();
		int res = 0;
		int localMax = 0;
		int start = 0;
		for(int i = 0; i < s.length(); i++) {

			if(positionOfChar.containsKey(s.charAt(i)) && positionOfChar.get(s.charAt(i)) >= start) {
				localMax = i - start;
				start = positionOfChar.get(s.charAt(i)) + 1;
				positionOfChar.put(s.charAt(i), i);
			} else {
				localMax = i - start + 1 ;
				positionOfChar.put(s.charAt(i), i);
			}
			res = localMax > res ? localMax : res;

		}
		
		return res;
    }	
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters x = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(x.lengthOfLongestSubstring("pwwkew"));
	}
}
