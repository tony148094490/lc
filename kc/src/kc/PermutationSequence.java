package kc;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
    	    	
    	int[] factorial = new int[n+1];
    	factorial[0] = 1;
    	for(int i = 1 ; i <= n;i++) {
    		factorial[i] = factorial[i-1] * i;
    	}
    	
    	
    	int availableNumberOfChars = n;
    	StringBuffer availableChars = new StringBuffer();
    	for(int i = 1 ; i <= n; i++){
    		availableChars.append(i);
    	}
    	
    	k--;
    	
    	StringBuffer res = new StringBuffer();
    	for(int i = 1; i <= n; i++){
    		int pos = k / factorial[availableNumberOfChars - 1];
    		    		
    		res.append(availableChars.charAt(pos));
    		availableChars.deleteCharAt(pos);
    		k = k - pos * factorial[availableNumberOfChars - 1];
    		availableNumberOfChars = availableNumberOfChars - 1;
    	}
    	
    	return res.toString();
    	
    }
    

    
    
    
    public static void main(String[] args) {
    	PermutationSequence x = new PermutationSequence();
    	
    	System.out.println(x.getPermutation(4, 14));
    	
    }
}
