package kc;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        int end = s.length() - 1;

    	int len = 0;

    	while(end >= 0 && s.charAt(end) == ' ') end--;

    	while(end >= 0 && s.charAt(end) != ' ') {

    		end--;

    		len++;

    	}

    	return len;
    }
    
    public static void main(String[] args) {
    	LengthOfLastWord sol = new LengthOfLastWord();
    	System.out.println(sol.lengthOfLastWord("Hello World"));
    }
}
