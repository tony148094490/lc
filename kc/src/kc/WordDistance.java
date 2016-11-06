package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
    Map<String, List<Integer>> map;
	public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++) {
        	if(map.containsKey(words[i])) {
        		map.get(words[i]).add(i);
        	} else {
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		map.put(words[i],list);
        	}
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> one = map.get(word1);
        List<Integer> two = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while(i < one.size() && j < two.size()) {
            res = Math.min(res, Math.abs(one.get(i) - two.get(j)));
        	if(one.get(i) > two.get(j)) {
        		j++;
        	} else {
        		i++;
        	}
        }
        return res;
    }
    
 // Your WordDistance object will be instantiated and called as such:
 // WordDistance wordDistance = new WordDistance(words);
 // wordDistance.shortest("word1", "word2");
 // wordDistance.shortest("anotherWord1", "anotherWord2");
    public static void main(String[] args) {
    	String[] arr = {"practice", "makes", "perfect", "coding", "makes"};
    	WordDistance x = new WordDistance(arr);
    	System.out.println(x.shortest("coding", "practice"));
    }
}
