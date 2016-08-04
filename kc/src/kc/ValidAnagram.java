package kc;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);Arrays.sort(tt);
        
        return new String(ss).equals(new String(tt));
        
    }
    
}
