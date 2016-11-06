package kc;

public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
    	char[] reverse = reverse(s,0,s.length-1);
    	for(int i = 0 ; i < reverse.length; i++) {
    		if(reverse[i] != ' ') {
    			int j = i;
    			while(j < reverse.length && reverse[j] != ' ') {
    				j++;
    			}
    			reverse(reverse,i,j-1);
    			i = j;
    		}
    	}
    }
    
    private char[] reverse(char[] s, int i, int j) {
    	while(i< j) {
    		char temp = s[i];
    		s[i] = s[j];
    		s[j] = temp;
    		i++;
    		j--;
    	}
    	return s;
    }
    public static void main(String[] args) {
    	ReverseWordsInAStringII a = new ReverseWordsInAStringII();
    	String x = "the sky is";
    	char[] arr = x.toCharArray();
    	a.reverseWords(arr);
    	System.out.println(new String(arr));
    }
}
