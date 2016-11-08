package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberIII {
    List<String> one = Arrays.asList(new String[]{"0", "1", "8"});
    List<String> two = Arrays.asList(new String[]{"00", "11", "69", "88", "96"});
	Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
	public int strobogrammaticInRange(String low, String high) {
	    if(low.length() > high.length() || ((low.length() == high.length()) && greater(low,high))) {
	    	return 0;
	    }

	    for(int i = low.length(); i <= high.length(); i++) {
	        findStrobogrammatic(i);
	    }
        map.put(1, one);

        List<String> lowList = map.get(low.length());
        if(low.length() < high.length()){
        	int i = 0;
        	while(i < lowList.size() && greater(low, lowList.get(i))) {
        		i++;
        	}
        	
        	List<String> highList = map.get(high.length());
        	int j = highList.size()-1;
        	while(j>=0 && greater(highList.get(j) , high)) {
        		j--;
        	}

        	int res = (lowList.size() - i) + (j + 1);
        	if(high.length() > low.length() + 1) {
        		for(int k = low.length() + 1; k < high.length(); k++) {
        			res += map.get(k).size();
        		}
        	}
        	return res;
        } else {
        	int i = 0;
        	int j = lowList.size()-1;
        	while((i<j) && (greater(low, lowList.get(i)) || greater(lowList.get(j), high))) {
        		while((i<j) && greater(low, lowList.get(i))) {
        			i++;
        		}
        		
        		while((i<j) && greater(lowList.get(j), high)){
        			j--;
        		}
        	}
        	return j - i + 1;
        }
    }
	
	private boolean greater(String a, String b) {
		for(int i = 0 ; i < a.length(); i++) {
			if(a.charAt(i) > b.charAt(i)) {
				return true;
			} else if(a.charAt(i) < b.charAt(i)) {
				return false;
			}
		}
		return false;
	}

    
	public List<String> findStrobogrammatic(int n) {
        if(n == 1) {
        	return one;
        }
        
        if(n == 2) {
        	List<String> res = new ArrayList<String>();
        	for(String str : two) {
        		if(!str.equals("00")) res.add(str);
        	}
        	map.put(2, res);
        	return res;
        }
        
        if (n%2 == 0) {
        	List<String> lessTwo = findStrobogrammatic(n-2);
        	List<String> res = getStrobo(lessTwo, two);
        	map.put(n, res);
        	return res;
        } else {
        	List<String> lessOne = findStrobogrammatic(n-1);
        	List<String> res = getStrobo(lessOne, one);
        	map.put(n, res);
        	return res;
        }
    }
    
    private List<String> getStrobo(List<String> even, List<String> one) {
    	List<String> res = new ArrayList<String>();
    	for(int i = 0; i < even.size(); i++) {
    		int mid = even.get(i).length() / 2;
    		for(String str : one) {
    			StringBuilder sb = new StringBuilder();
    			sb.append(even.get(i).substring(0, mid));
    			sb.append(str);
    			sb.append(even.get(i).subSequence(mid, even.get(i).length()));
    			res.add(sb.toString());
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	StrobogrammaticNumberIII x = new StrobogrammaticNumberIII();
    	System.out.println(x.strobogrammaticInRange("0","0"));
    }
}
