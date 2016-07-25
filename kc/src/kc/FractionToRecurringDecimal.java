package kc;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
	
    public String fractionToDecimal(int numerator, int denominator) {
    	long n = numerator;
    	long d = denominator;
    	String minus = "";
    	if( (n < 0 && d > 0) || (n > 0 && d < 0)) {
    		minus = "-";
    	}
    	n = Math.abs(n);
    	d = Math.abs(d);
    	
    	String preDeci = String.valueOf(n/d);
    	
        StringBuilder sb = new StringBuilder();
        sb.append(minus);
        sb.append(preDeci);
        
        long remainder = n % d;
        if(remainder == 0) return sb.toString();
        
        sb.append(".");
        Map<Long, Integer> remainderToPosition = new HashMap<Long, Integer>();
        remainderToPosition.put(remainder, sb.length());
        
        while(remainder != 0) {
        	n = remainder * 10;
        	sb.append(n/d); System.out.println(d);
        	remainder = n % d;
        	if(remainderToPosition.containsKey(remainder)) {
        		sb.insert(remainderToPosition.get(remainder), "(");
        		sb.append(")");
        		break;
        	} else {
        		remainderToPosition.put(remainder, sb.length());
        	}
        }

        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractionToRecurringDecimal x = new FractionToRecurringDecimal();
		
		System.out.println(x.fractionToDecimal(-1,-2147483648));
		
	}

}
