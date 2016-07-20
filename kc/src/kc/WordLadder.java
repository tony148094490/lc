package kc;

import java.util.HashSet;
import java.util.Set;

public class WordLadder {
    
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || beginWord.length() == 0 || endWord == null 
        		|| endWord.length() == 0 || wordList == null || wordList.size() == 0) return 0;
        if(beginWord.equals(endWord)) return 0;
        wordList.add(endWord);
		Set<String> neighbours = new HashSet<String>();
		neighbours.add(beginWord);
		wordList.remove(beginWord);
		int res = 0;
		while(!neighbours.isEmpty()) {
			res++;
			if(neighbours.contains(endWord)) {
				return res;
			} 
			
			Set<String> newNeigh = new HashSet<String>();
			for(String str : neighbours) {
				wordList.remove(str);
				getNext(str, wordList, newNeigh);
			}
			neighbours = newNeigh;
		}
		return 0;
    }
	
	private void getNext(String cur, Set<String> set, Set<String> curRes) {
		char[] chars = cur.toCharArray();
		for(int i = 0 ; i < cur.length(); i++){
			for(char a = 'a' ; a <= 'z' ;a++){
				char current = chars[i];
				if(chars[i] == a) continue;
				chars[i] = a;
				String newString = new String(chars);
				if(set.contains(newString)){
					curRes.add(newString);
				} 
				chars[i] = current;
			}
		}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		
		Set<String> set2 = new HashSet<String>();
		set2.add("a");
		set2.add("b");
		set2.add("c");

		
		
		WordLadder x = new WordLadder();
		System.out.println(x.ladderLength("hot", "hot", set));
	}

}
