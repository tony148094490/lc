package kc;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if(a == null || a.length() == 0 || b == null || b.length() == 0) return sb.toString();
        
        int sum = 0;
        int carry = 0;
        
        int ae = a.length() - 1;
        int be = b.length() - 1;
        
        while(ae >= 0 && be >= 0) {
        	sum = (int) (a.charAt(ae) - '0' ) + (int) (b.charAt(be) - '0') + carry;
        	sb.append(sum % 2);
        	carry = sum / 2;
        	ae--;
        	be--;
        }
        
        if(ae >= 0) {
        	while(ae >= 0) {
        		sum = (int) (a.charAt(ae) - '0') + carry;
        		sb.append(sum % 2);
        		carry = sum / 2;
        		ae--;
        	}
        } else if (be >= 0){
        	while( be >= 0) {
	    		sum = (int) (b.charAt(be) - '0') + carry;
	    		sb.append(sum % 2);
	    		carry = sum / 2;
	    		be--;
        	}
        }
        
        if(carry != 0) sb.append(carry);
        
        return sb.reverse().toString();
        
    }
    
    public static void main(String[] args) {
    	AddBinary ad = new AddBinary();
    	System.out.println(ad.addBinary("1", "11"));
    }

}
