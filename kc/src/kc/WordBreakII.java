package kc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = helper(s, wordDict, new HashMap<String, List<String>>());
        return res != null ? res : new ArrayList<String>();
    }
    
    private List<String> helper(String s, Set<String> dict, Map<String, List<String>> dp) {
        if(dp.containsKey(s)) return dp.get(s);
        if(s.length() == 0) {
            List<String> res = new ArrayList<String>();
            return res;
        }

        List<String> res = null;
        for(String str : dict) {
            if(s.startsWith(str)) {
                List<String> next = helper(s.substring(str.length()), dict, dp);
                if(next == null) continue;
                if(res == null)
                res = new ArrayList<String>();
                if(next.isEmpty()) {
                    res.add(str);
                } else {
                    for(String ss : next) {
                        res.add(str + (ss.length() == 0 ? "" : " ") + ss);
                    }
                }
            }
        }
        dp.put(s, res);
        return res;
    }
    
    
    public static void main(String[] args) {
//    	WordBreakII x = new WordBreakII();
//    	String s = "abcd";
//    	Set<String> set = new HashSet<String>();
//    	String[] dict = {"a","abc","b","cd"};
//    	for(String str: dict) set.add(str);
//    	System.out.println(x.wordBreak(s, set));
    	BigDecimal a = new BigDecimal(1212.1).setScale(2, BigDecimal.ROUND_HALF_UP);
    	System.out.println(a);
	}
}
