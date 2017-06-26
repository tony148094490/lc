package airbnb;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	if(num1.length() == 0 || num2.length() == 0) return new String();
    	
    	int[] res = new int[num1.length() + num2.length()];
    	
    	for(int i = num1.length()-1 ; i >= 0; i--) {
    		for(int j = num2.length()-1; j >=0; j--) {
    			int c = (int)(num1.charAt(i) - '0') * (int)(num2.charAt(j) - '0');
    			res[i + j] += (res[i+j + 1] + c) / 10;
    			res[i+j+1] = (res[i+j+1] + c) %10;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	int i = 0;
    	while(i<res.length -1 && res[i] == 0) {
    		i++;
    	}
    	
		while(i<=res.length-1){
			sb.append(res[i]);
			i++;
		}
    	return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings x = new MultiplyStrings();
		System.out.println(x.multiply("99",	 "0"));
	}

}
