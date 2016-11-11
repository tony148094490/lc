package kc;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutations {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
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
        return (single == 0)||(single == 1 && s.length() % 2 == 1);
    }
}
