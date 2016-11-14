package kc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation {
	
    Map<String, Set<String>> map = new HashMap<String,Set<String>>();
    public UniqueWordAbbreviation(String[] dictionary) {
        for(String str : dictionary) {
            if(str.length() <= 2) continue;
            String abbr = str.charAt(0) + String.valueOf(str.length()-2) + str.charAt(str.length() - 1);
            if(map.containsKey(abbr)) {
                map.get(abbr).add(str);
            } else {
                Set<String> set = new HashSet<String>();
                set.add(str);
                map.put(abbr, set);
            }
        }
    }

    public boolean isUnique(String word) {
        if(word.length() <= 2) return true;
        String abbr = word.charAt(0) + String.valueOf(word.length()-2) + word.charAt(word.length() - 1);
        if(!map.containsKey(abbr)) {
            return true;
        } else {
            Set<String> words = map.get(abbr);
            if(words.size() == 1 && words.contains(word)) return true;
            return false;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");