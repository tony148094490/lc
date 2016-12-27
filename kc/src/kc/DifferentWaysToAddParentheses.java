package kc;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
    		List<Integer> res = new ArrayList<Integer>();
    		for(int i = 0; i < input.length();i++) {
    			char operator = input.charAt(i);
    			if(operator > '9' || operator < '0') {
	    			List<Integer> firstHalf = diffWaysToCompute(input.substring(0,i));
	    			List<Integer> secondHalf = diffWaysToCompute(input.substring(i+1));
	    			for(Integer a : firstHalf) {
	    				for(Integer b : secondHalf) {
	    					switch(operator) {
	    		    			case '+' :
	    		    				res.add(a+b);
	    		    				break;
	    		    			case '-' :
	    		    				res.add(a-b);
	    		    				break;
	    		    			case '*' :
	    		    				res.add(a*b);
	    		    				break;
	    		    		}
	    				}
	    			}
    			}
    			
    		}
    		if(res.isEmpty()) res.add(Integer.parseInt(input));
    		return res;
    	
    }
    public static void main(String[] args) {
		String a = "1-5-4*3";
		DifferentWaysToAddParentheses x = new DifferentWaysToAddParentheses();
		System.out.println(x.diffWaysToCompute(a));
	}
}
