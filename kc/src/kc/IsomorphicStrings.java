package kc;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        Map<Character, Character> mapS = new HashMap<Character, Character>();
        Map<Character, Character> mapT = new HashMap<Character, Character>();
        
        for(int i = 0 ;i < s.length() ; i++ ){
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if(!mapS.containsKey(ss) && !mapT.containsKey(tt)) {
                mapS.put(ss,tt);
                mapT.put(tt,ss);
            } else if(!mapS.containsKey(ss) || !mapT.containsKey(tt)) {
                return false;
            } else {
                if(mapS.get(ss) != tt || mapT.get(tt) != ss) return false;
            }
        }
        return true;
    }
}
