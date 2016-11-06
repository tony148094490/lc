package kc;

public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(word1.equals(word2)) {
        	int last = -1;
        	int res = Integer.MAX_VALUE;
        	for(int i = 0 ; i < words.length;i++) {
        		if(words[i].equals(word1)) {
        			if(last != -1 ) {
        				res = Math.min(res, i - last);
        			}
    				last = i;
        		}
        	}
        	return res;
        } else {
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
    }
}
