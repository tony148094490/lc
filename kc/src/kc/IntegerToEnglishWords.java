package kc;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
	Map<Integer, String> singles = new HashMap<Integer, String>();
    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        if(num == 0) return "Zero";
        
        initMaps();
        
        // get billion
        if(num >= 1000000000) {
            int billion = num / 1000000000;
            String number = getNumber(billion);
            sb.append(number);
            sb.append(" Billion ");
            num -= billion * 1000000000;
        }
        
        // get million
        if(num >= 1000000) {
            int million = num / 1000000;
            String number = getNumber(million);
            sb.append(number);
            sb.append(" Million ");
            num -= million * 1000000;
        }
        
        // get thousand
        if(num >= 1000) {
            int thousand = num / 1000;
            String number = getNumber(thousand);
            sb.append(number);
            sb.append(" Thousand ");
            num -= thousand * 1000;
        }
        
        // get rest
        if(num > 0) {
            sb.append(getNumber(num));
            return sb.toString();
        }
        
        return sb.substring(0, sb.length()-1).toString();
    }
    
    private String getNumber(int num) {
        StringBuilder sb = new StringBuilder();
        if(num >= 100) {
            int hundred = num / 100;
            sb.append(singles.get(hundred));
            sb.append(" Hundred ");
            num -= hundred * 100;
        }
        
        if(num == 0) return sb.toString().substring(0, sb.length()-1);
        
        if(num < 10) {
            sb.append(singles.get(num));
            return sb.toString();
        }
        
        if(num == 10) {
            sb.append(singles.get(10));
            return sb.toString();
        }
        
        if(num >= 20) {
            int remainder = num % 10;
            sb.append(singles.get(num - remainder));
            num = remainder;
            if(num != 0) {
                sb.append(" ");
                sb.append(singles.get(num));
            }
        } else if(num > 10) {
            sb.append(singles.get(num));
        }
        
        return sb.toString();
    }
    
    private void initMaps() {
        singles.put(1, "One");
        singles.put(2, "Two");
        singles.put(3, "Three");
        singles.put(4, "Four");
        singles.put(5, "Five");
        singles.put(6, "Six");
        singles.put(7, "Seven");
        singles.put(8, "Eight");
        singles.put(9, "Nine");
        
        singles.put(11, "Eleven");
        singles.put(12, "Twelve");
        singles.put(13, "Thirteen");
        singles.put(14, "Fourteen");
        singles.put(15, "Fifteen");
        singles.put(16, "Sixteen");
        singles.put(17, "Seventeen");
        singles.put(18, "Eighteen");
        singles.put(19, "Nineteen");

        singles.put(10, "Ten");
        singles.put(20, "Twenty");
        singles.put(30, "Thirty");
        singles.put(40, "Forty");
        singles.put(50, "Fifty");
        singles.put(60, "Sixty");
        singles.put(70, "Seventy");
        singles.put(80, "Eighty");
        singles.put(90, "Ninety");
        
    }
    
    public static void main(String[] args) {
    	IntegerToEnglishWords x = new IntegerToEnglishWords();
    	System.out.println(x.numberToWords(123));
	}
}
