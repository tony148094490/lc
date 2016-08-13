package kc;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
    	
    	int firstStart = 0;
    	int firstEnd = 0;
    	int secondStart = 0;
    	int secondEnd = 0;
    	for(int i = 0 ; i <= num.length()/2; i++) {
    		for(int j = i + 1; j < num.length(); j++) {
    			if(num.charAt(0) == '0' && i > 0) return false;
    			if(num.charAt(i+1) == '0' && j > i + 1) break;
    			String sum = getSum(num.substring(0,i+1), num.substring(i + 1, j +1));
    			if(sum.length() <= num.length() - j - 1 && sum.equals(num.subSequence(j+1, j+1+sum.length()))){
    				firstStart = i+1;
    				firstEnd = j;
    				secondStart = j+1;
    				secondEnd = j+1+sum.length()-1;
    				if(helper(firstStart, firstEnd,secondStart,secondEnd, num)) return true;
    			}
    		}
    	}
    	return false;
    }
    	
    private boolean helper(int firstStart, int firstEnd, int secondStart, int secondEnd, String num){
    	while(secondEnd < num.length() - 1){
    		String sum = getSum(num.substring(firstStart, firstEnd+1), num.substring(secondStart, secondEnd+1));
    		if(sum.length() <= num.length() - secondEnd - 1 && sum.equals(num.subSequence(secondEnd+1, secondEnd+1+sum.length()))){
				firstStart = secondStart;
				firstEnd = secondEnd;
				secondStart = secondEnd+1;
				secondEnd = secondEnd+1+sum.length()-1;
			} else {
				return false;
			}
    	}
    	return true;
    }
    
    private String getSum(String a, String b) {

    	if(a.length() < b.length()) return getSum(b,a);
    	int lenA = a.length()-1;
    	int lenB = b.length()-1;
    	
    	int carry = 0;
    	int digitA = 0;
    	int digitB = 0;
    	StringBuilder sb = new StringBuilder();
    	while(lenB >= 0) {
    		digitA = a.charAt(lenA) - '0';
    		digitB = b.charAt(lenB) - '0';
    		sb.append((digitA + digitB + carry) %10);
    		carry = (digitA + digitB + carry)/10;
    		lenB--;
    		lenA--;
    	}
    	while(lenA >= 0) {
    		digitA = a.charAt(lenA) - '0';
    		sb.append((digitA + carry) %10);
    		carry = (digitA + carry)/10;
    		lenA--;
    	}
    	if(carry == 1) {
    		sb.append(1);
    	}

    	return sb.reverse().toString();
    }
    
    
    public static void main(String[] args) {
    	AdditiveNumber x = new AdditiveNumber();
    	System.out.println(x.isAdditiveNumber("101020305080130210"));
	}
    
}
