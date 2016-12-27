package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {
        List<String> res = new ArrayList<String>();
        int count = 0;
        for(int i = low.length() ; i <= high.length(); i++) {
            res.addAll(helper(i, i));
        }
        for(String x : res) {
            if((x.length() == low.length() && x.compareTo(low) < 0) || (x.length() == high.length() && x.compareTo(high) > 0))
            continue;
            count++;
        }
        return count;
    }
    
    static Map<String, String> map = new HashMap<String, String>();
    static {map.put("1","1");
    map.put("0","0");
    map.put("6","9");
    map.put("9","6");
    map.put("8","8");
    }
    
    private List<String> helper(int n, int m) {
        if(n == 0) {
            List<String> res = new ArrayList<String>();
            res.add("");
            return res;
        }
        
        if(n == 1) {
            List<String> res = new ArrayList<String>();
            res.add("1");
            res.add("0");
            res.add("8");
            return res;
        }
        
        List<String> last = helper(n-2,m);
        List<String> res = new ArrayList<String>();
        for(String str : last) {
            for(Entry<String, String> entry : map.entrySet()) {
                if((entry.getKey().equals("0") && m != n) || !entry.getKey().equals("0")) {
                    res.add(entry.getKey() + str + entry.getValue());
                }
            }            
        }
        return res;
    }   
    
    
    public static void main(String[] args) {
    	StrobogrammaticNumberIII x = new StrobogrammaticNumberIII();
    	System.out.println(x.strobogrammaticInRange("0","0"));
    }
}
