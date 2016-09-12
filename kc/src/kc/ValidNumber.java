package kc;

public class ValidNumber {
	// try using regex next time
    public boolean isNumber(String s) {
        s = s.trim();
    	if(s.length() == 0) return false;
        
    	if(s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
    	if(s.length() == 0) return false;
    	    	
    	boolean dot = false;
        boolean e = false;
        boolean number = false;
        
        for(int i = 0 ; i < s.length();i++) {
        	if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        		if(!number) number = true;
        		continue;
        	} else if(s.charAt(i) == '.') {
        		if(dot || e) return false;
        		if(i == s.length() - 1) return number;
        		dot = true;
        	} else if(s.charAt(i) == 'e') {
        		if(e) return false;
        		if(number == false) return false;
        		if(i == s.length() - 1) return false;
        		if(s.charAt(i+1) == '-' || s.charAt(i+1) == '+') {
        			i++;
        			if(i == s.length() - 1) return false;
        		}
        		e = true;
        	} else {
        		return false;
        	}
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	ValidNumber x = new ValidNumber();
    	System.out.println(x.isNumber("0"));
    	System.out.println(x.isNumber(" 0.1 "));
    	System.out.println(x.isNumber("abc"));
    	System.out.println(x.isNumber("1 a"));
    	System.out.println(x.isNumber("2e10"));
    	System.out.println(x.isNumber("e9"));
    	System.out.println(x.isNumber("01"));
    	System.out.println(x.isNumber("3."));
    	System.out.println(x.isNumber("."));
    	System.out.println(x.isNumber(".1"));
    	System.out.println(x.isNumber(" 005047e+6"));
    	System.out.println(x.isNumber(" 4e+"));
    	
    }
}
