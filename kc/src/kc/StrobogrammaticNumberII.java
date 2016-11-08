package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberII {
	
    List<String> one = Arrays.asList(new String[]{"0", "1", "8"});
    List<String> two = Arrays.asList(new String[]{"00", "11", "69", "88", "96"});
    
	public List<String> findStrobogrammatic(int n) {
        if(n == 1) {
        	return one;
        }
        
        if(n == 2) {
        	List<String> res = new ArrayList<String>();
        	for(String str : two) {
        		if(!str.equals("00")) res.add(str);
        	}
        	return res;
        }
        
        if (n%2 == 0) {
        	List<String> lessTwo = findStrobogrammatic(n-2);
        	return getStrobo(lessTwo, two);
        } else {
        	List<String> lessOne = findStrobogrammatic(n-1);
        	return getStrobo(lessOne, one);
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
    	StrobogrammaticNumberII x = new StrobogrammaticNumberII();
    	System.out.println(x.findStrobogrammatic(4));
    }
}
