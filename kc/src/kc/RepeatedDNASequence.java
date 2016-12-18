package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> existing = new HashSet<Integer>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        List<String> res = new ArrayList<String>();
        for(int i = 0 ; i < s.length() - 9; i++) {
            int codedNr = 0;
            for(int j = i; j < i + 10; j++) {
                codedNr <<= 2;
                codedNr |= map.get(s.charAt(j));
            }
            if(set.contains(codedNr) && !existing.contains(codedNr)) {
                res.add(s.substring(i, i+10));
                existing.add(codedNr);
            } else if (!set.contains(codedNr)){
                set.add(codedNr);
            }
        }
        return res;
    }
}
