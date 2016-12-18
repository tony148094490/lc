package kc;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
	
    public String fractionToDecimal(int numerator, int denominator) {
        String minus = "";
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) minus = "-";
        StringBuffer sb = new StringBuffer();
        sb.append(minus);
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        sb.append(num/den);
        if(num % den == 0) return sb.toString();
        long remainder = num % den;
        sb.append(".");
        Map<Long, Integer> remainderToPosition = new HashMap<Long, Integer>();
        // repetition starts after dot. This map denotes the beginning of the repetition.
        remainderToPosition.put(remainder, sb.length());
        while(remainder != 0) {
            num = remainder * 10;
            sb.append(num/den);
            remainder = num % den;
            if(remainderToPosition.containsKey(remainder)) {
                sb.insert(remainderToPosition.get(remainder), "(");
                sb.append(")");
                return sb.toString();
            } else {
                remainderToPosition.put(remainder, sb.length());
            }
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractionToRecurringDecimal x = new FractionToRecurringDecimal();
        char c = 'A' + 6;

		System.out.println(c);
		
	}

}
