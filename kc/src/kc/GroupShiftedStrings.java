package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> res = new ArrayList<List<String>>();
        for(String str : strings) {
        	if(map.containsKey(str.length())) {
        		 List<List<String>> listOfList = map.get(str.length());
        		 boolean found = false;
        		 for(List<String> list : listOfList) {
        			 String strToCompare = list.get(0);
        			 if(isShifted(strToCompare, str)) {
        				 list.add(str);
        				 found = true;
        				 break;
        			 }
        		 }
    			 if(!found) {
    				 List<String> list = new ArrayList<String>();
    				 list.add(str);
    				 res.add(list);
    				 listOfList.add(list);
    			 }
        	} else {
        		List<List<String>> listOfList = new ArrayList<List<String>>();
        		List<String> list = new ArrayList<String>();
        		list.add(str);
        		res.add(list);
        		listOfList.add(list);
        		map.put(str.length(), listOfList);
        	}
        }
        return res;
    }
    private boolean isShifted(String a, String b) {
    	int shiftedPos = (b.charAt(0) - a.charAt(0));
    	if(shiftedPos < 0) shiftedPos = shiftedPos + 26;
    	for(int i = 1 ; i < a.length(); i++) {
    		int cur = b.charAt(i) - a.charAt(i);
    		if (cur < 0) {
    			cur = cur + 26; 
    		}
    		if(cur != shiftedPos) return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	GroupShiftedStrings x = new GroupShiftedStrings();
    	String[] arr = {"abc","bcd","acef","ade","bdfg","az","ba","a","z"};
    	System.out.println(x.groupStrings(arr));
    }
}
