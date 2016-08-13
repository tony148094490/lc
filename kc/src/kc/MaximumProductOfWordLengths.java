package kc;


public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
    	if(words.length <= 1) return 0;
        int max = 0;
        int[] numbers = new int[words.length];
        for(int i = 0 ; i < words.length; i++) {
        	String str = words[i];
        	for(int j = 0 ; j < str.length(); j++) {
        		numbers[i] |= 1 << (str.charAt(j) - 'a');
        	}
        }
        
        for(int i = 0 ; i < words.length - 1; i++) {
        	for(int j = i + 1 ; j < words.length; j++) {
        		if((numbers[i] & numbers[j]) == 0 && max < (words[i].length() * words[j].length())) {
        			max = words[i].length() * words[j].length();
        		}
        	}
        }
        return max;
    }
    
    
}
