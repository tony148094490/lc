package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RecontructItinerary {

    public List<String> findItinerary(String[][] tickets) {
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	for(int i = 0; i < tickets.length; i++) {
        	String a = tickets[i][0];
        	String b = tickets[i][1];
        	if(map.containsKey(a)) {
        		insert(map.get(a) ,b);
        	} else {
        		List<String> list = new ArrayList<String>();
        		list.add(b);
        		map.put(a, list);
        	}
        }
    	
    	for(Entry<String, List<String>> entry : map.entrySet()) {
    		System.out.print(entry.getKey() + "," + entry.getValue());
    		System.out.println();
    	}
    	
    	List<String> res = new ArrayList<String>();
    	res.add("JFK");
    	dfs(res, "JFK", map);
    	
    	return res;
    }
    
    private boolean dfs(List<String> res, String cur, Map<String, List<String>> map) {
    	if(map.size() == 0) return true;
    	
    	if(map.containsKey(cur)) {
    		for(int i = 0 ; i < map.get(cur).size(); i++) {
	    		String next = map.get(cur).remove(i);
	    		res.add(next);
	    		if(map.get(cur).size() == 0) map.remove(cur);
	    		if(dfs(res,next, map)) {
	    			return true;
	    		} else {
	    			if(!map.containsKey(cur)) {
	    				List<String> list = new ArrayList<String>();
	    				list.add(next);
	    				map.put(cur,list);
	    			} else {
	    				map.get(cur).add(i,next);
	    			}
	    			res.remove(res.size()-1);
	    		}
    		}
    	}
    	
    	return false;
    	
    }
    
    private void insert(List<String> list, String a) {
    	for(int i = 0 ; i < list.size(); i++) {
    		String b = list.get(i);
    		if(before(a, b)) {
    			list.add(i, a);
    			return;
    		}
    	}
    	list.add(list.size(), a);
    }
    
    private boolean before(String a, String b) {
    	for(int i = 0 ; i < a.length(); i++) {
    		if(a.charAt(i) < b.charAt(i)) {
    			return true;
    		} else if (a.charAt(i) > b.charAt(i)) {
    			return false;
    		}
    	}
    	return true;
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
