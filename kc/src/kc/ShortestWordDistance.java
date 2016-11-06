package kc;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int lastWord1 = -1;
        int lastWord2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < words.length; i++) {
        	if(words[i].equals(word1)) {
        		lastWord1 = i;
        		if(lastWord2 != -1) {
        			res = Math.min(res, lastWord1 - lastWord2);
        		}
        	} else if(words[i].equals(word2)) {
        		lastWord2 = i;
        		if(lastWord1 != -1) {
        			res = Math.min(res, lastWord2 - lastWord1);
        		}
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
    	String[] arr = {"practice", "makes", "perfect", "coding", "makes"};
    	ShortestWordDistance x = new ShortestWordDistance();
    	System.out.println(x.shortestDistance(arr, "coding", "practice"));
    }
}
