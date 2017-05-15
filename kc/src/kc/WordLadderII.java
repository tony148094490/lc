package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for(String str : wordList) dict.add(str);
        dict.remove(beginWord);
        Map<String, Set<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        Set<String> parents = new HashSet<>();
        parents.add(beginWord);
        Set<String> children = new HashSet<>();
        boolean found = false;
        while(!parents.isEmpty()) {
            for(String parent : parents) {
                Set<String> kids = getNeighbors(parent, dict);
                if(kids.contains(endWord)) {
                    found = true;
                    LinkedList<String> path = new LinkedList<>();
                    path.add(endWord);
                    getRes(parent, map, path, res);
                }
                
                if(!found) {
                    children.addAll(kids);
                    for(String str : kids) {
                        Set<String> folks = map.get(str);
                        if(folks == null) folks = new HashSet<>();
                        folks.add(parent);
                        map.put(str, folks);
                    }
                }
            }
                            
            if(!found) {
                dict.removeAll(children);
                parents = children;
                children = new HashSet<>();
            } else {
                break;
            }
        }
        return res;
    }
    
    private void getRes(String parent, Map<String, Set<String>> map, LinkedList<String> path, List<List<String>> res) {
        if(!map.containsKey(parent)) {
            path.add(0,parent);
            res.add(new ArrayList<>(path));
            path.removeFirst();
            return;
        }
        path.add(0, parent);
        for(String child : map.get(parent)) {
            getRes(child, map, path, res);
        }
        path.removeFirst();
    }
    
    private Set<String> getNeighbors(String str, Set<String> dict) {
        Set<String> res = new HashSet<>();
        char[] chars = str.toCharArray();
        for(int i = 0 ; i < str.length(); i++) {
            char cur = str.charAt(i);
            for(char j = 'a'; j <= 'z'; j++) {
                if(j == cur) continue;
                chars[i] = j;
                String toCheck = new String(chars);
                if(dict.contains(toCheck)) res.add(toCheck);
            }
            chars[i] = cur;
        }
        return res;
    }
    
    public static void main(String[] args) {
    	List<String> wordList = new LinkedList<String>();
    	wordList.add("red");
    	wordList.add("ted");
    	wordList.add("tex");
    	wordList.add("tax");
    	wordList.add("tad");
    	wordList.add("den");
    	wordList.add("rex");
    	wordList.add("pee");
    
    	List<String> wordList2 = new LinkedList<String>();
    	wordList2.add("hot");
    	wordList2.add("dot");
    	wordList2.add("dog");
    	wordList2.add("lot");
    	wordList2.add("log");
    	
    	WordLadderII x = new WordLadderII();
    	System.out.println(x.findLadders("red", "tax", wordList));
    	System.out.println(x.findLadders("hit", "cog", wordList2));
    	
    }

    
}
