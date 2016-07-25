package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> res = new HashMap<String, Integer>();
        
        if(s==null || s.length() < 11) return new ArrayList<String>();
        
        int st = 0;
        int e = 10;
        String cur = "";
        List<String> r = new ArrayList<String>();

        while(e<=s.length()) {
            cur = s.substring(st,e);
            if(res.containsKey(cur) ){ res.put(cur, res.get(cur) + 1);
                if(res.get(cur) == 2) r.add(cur);
            }
            else {res.put(cur, 1);}
            st++;
            e++;
        }
        
        return r;
    }
}
