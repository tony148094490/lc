package kc;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
    public String numberToWords(int num) {
    	if(num == 0) return "Zero";
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");
        
        StringBuilder sb = new StringBuilder();
        int bucket = 1000000000;
        while(num > 0) {
        	int cur = num / bucket;
        	int hundred = cur / 100;
        	int ones = cur % 10;
        	int tens = (cur - cur / 100 * 100);
        	
        	
        	if(hundred > 0) {
        		sb.append(map.get(hundred));
        		sb.append(" ");
        		sb.append("Hundred");
        		sb.append(" ");
        	}
        	
        	if(tens > 20) {
        		sb.append(map.get(tens - ones));
        		sb.append(" ");
        		if(ones > 0) {
        			sb.append(map.get(ones));
        			sb.append(" ");
        		}
        	} else if(tens > 0) {
        		sb.append(map.get(tens));
        		sb.append(" ");
        	}
        	
        	if((hundred > 0 || tens > 0 || ones > 0) && bucket > 1){
        		sb.append(map.get(bucket));
        		sb.append(" ");
        	}
        	
        	num = num - num / bucket * bucket;
        	
        	bucket /= 1000;
        	
        }
        return sb.substring(0,sb.length()-1);
    }
    
    public static void main(String[] args) {
    	IntegerToEnglishWords x = new IntegerToEnglishWords();
    	System.out.println(x.numberToWords(123));
	}
}
