package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecontructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for(String[] strs : tickets) {
            if(map.containsKey(strs[0])) {
                insertToList(map.get(strs[0]), strs[1]);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(strs[1]);
                map.put(strs[0], list);
            }
        }
        List<String> res = new ArrayList<String>();
        res.add("JFK");
        helper(map, "JFK", res);
        return res;
    }
    private void insertToList(List<String> list, String str) {
        int i = 0;
        for(i = 0 ; i < list.size(); i++) {
            if(isGreater(list.get(i), str)) break;
        }
        list.add(i, str);
    }
    
    private boolean isGreater(String a, String b) {
        int i = 0;
        int j = 0;
        while(i < a.length() && j < b.length() && a.charAt(i) == b.charAt(j)) {
            i++;
            j++;
        }
        if(i == a.length()) return false;
        if(j == b.length()) return true;
        if(a.charAt(i) > b.charAt(j)) return true;
        return false;
    }
    
    private boolean helper(Map<String, List<String>> map, String cur, List<String> res) {
        if(map.isEmpty()) return true;
        if(!map.containsKey(cur)) return false;
        List<String> destinations = map.get(cur);
        for(int i = 0 ; i < destinations.size(); i++) {
            String next = destinations.remove(i);
            res.add(next);
            if(destinations.size() == 0) map.remove(cur);
            if(helper(map, next, res)) return true;
            destinations.add(i, next);
            if(!map.containsKey(cur)) map.put(cur, destinations);
            res.remove(res.size()-1);
        }
        return false;
    }
    
    public static void main(String[] args) {
    	RecontructItinerary x = new RecontructItinerary();
    	String[][] arr = new String[3][2];
//    	arr = {["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]};
// [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    	arr[0][0] = "JFK";
    	arr[0][1] = "KUL";
    	
    	arr[1][0] = "JFK";
    	arr[1][1] = "NRT";
    	
    	arr[2][0] = "NRT";
    	arr[2][1] = "JFK";
    	
//    	arr[3][0] = "ATL";
//    	arr[3][1] = "JFK";
//    	
//    	arr[4][0] = "ATL";
//    	arr[4][1] = "SFO";
//    	
    	
    	System.out.println(x.findItinerary(arr));
	}
}
