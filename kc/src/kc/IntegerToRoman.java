package kc;

public class IntegerToRoman {
    
	String[] romans = {"I", "V", "X", "L", "C", "D", "M"};
	int[] dec =        {1,   5,   10, 50,   100, 500, 1000};
	
	public String intToRoman(int num) {
    	
        int pos = dec.length - 1;
        StringBuilder sb = new StringBuilder();
        while(num > 0){
        	
        	if (num >= dec[pos] || (pos >= 1 && dec[pos] == 5 * dec[pos-1] && num >= (dec[pos]- dec[pos-1])) || 
        			(pos>= 2 && dec[pos] == 10*dec[pos-2] && dec[pos] == dec[pos-1] * 2 && num >= (dec[pos]-dec[pos-2]))) {
        		
        		while(num >= dec[pos]) {
        			sb.append(romans[pos]);
        			num = num - dec[pos];
        		}
        		
         		if(pos >= 1 && dec[pos] == 5 * dec[pos-1] && num >= (dec[pos]- dec[pos-1])) {
        			sb.append(romans[pos-1]);
        			sb.append(romans[pos]);
        			num = num - (dec[pos] - dec[pos-1]);
        		}
        		
        		
        		if(pos>= 2 && dec[pos] == 10*dec[pos-2] && dec[pos] == dec[pos-1] * 2 && num >= (dec[pos]-dec[pos-2])) {
        			sb.append(romans[pos-2]);
        			sb.append(romans[pos]);
        			num = num - (dec[pos] - dec[pos-2]);
        		}
        		pos--;
        		
        	} else {
        		pos--;
        	}
        }
        return sb.toString();
    }
	
	
	public int romanToInt(String s) {
		int pos = romans.length - 1;
		int res = 0;
		int i = 0;
		while(i < s.length()) {
			
			if(s.substring(i,i+1).equals(romans[pos]) || (pos >=1 && (i<s.length() - 1) && s.substring(i,i+2).equals((romans[pos -1 ] + romans[pos]))) || 
					(pos>=2 && (i<s.length() - 1) && s.substring(i,i+2).equals(romans[pos - 2] + romans[pos])) ) {
				
				while(i<s.length() && s.substring(i,i+1).equals(romans[pos])) {
					i++;
					res += dec[pos];
				}
				
				if(pos >=1 && (i<s.length() - 1) && s.substring(i,i+2).equals((romans[pos - 1] + romans[pos]))) {
					i = i + 2;
					res += (dec[pos] - dec[pos-1]);

				}
				
				if(pos>=2 && (i<s.length() - 1) && s.substring(i,i+2).equals(romans[pos - 2] + romans[pos])) {
					i = i + 2;
					res += (dec[pos] - dec[pos - 2]);
				}
			} else {
				pos--;

			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		IntegerToRoman i = new IntegerToRoman();
		System.out.println(i.romanToInt(i.intToRoman(7)));
		
	}
}
