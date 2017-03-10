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
        List<List<String>> res = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String str : wordList) set.add(str);
        if(!set.contains(endWord)) return res;
        Set<String> parents = new HashSet<>();
        parents.add(beginWord);
        set.remove(beginWord);
        boolean found = false;
        Set<String> childrenList = new HashSet<>();
        while(!parents.isEmpty()) {
            for(String parent : parents) {
                Set<String> children = getChildren(parent, set, childrenList);
                if(children.contains(endWord)) found = true;
                if(found && children.contains(endWord)) {
                    LinkedList<String> newRes = new LinkedList<>();
                    newRes.add(endWord);
                    getPath(parent, map, newRes, res);
                } else {
                    for(String str : children) {
                        Set<String> resSet= map.get(str);
                        if(resSet == null) resSet = new HashSet<>();
                        resSet.add(parent);
                        map.put(str, resSet);
                    }
                }
            
            }
            if(found) {
                break;
            }
            parents = childrenList;
            childrenList = new HashSet<>();
            for(String str : parents) set.remove(str);
        }
        

        return res;
    }
    
    private void getPath(String parent, Map<String, Set<String>> map, LinkedList<String> cur, List<List<String>> res) {
        cur.addFirst(parent);
        if(!map.containsKey(parent)) {
            res.add(new LinkedList<String>(cur));
        } else {
            for(String str : map.get(parent)) {
                getPath(str, map, cur, res);
            }
        }
        cur.removeFirst();
    }
    
    private Set<String> getChildren(String parent, Set<String> dict, Set<String> children) {
        char[] arr = parent.toCharArray();
        Set<String> res = new HashSet<>();
        for(int i = 0 ; i < parent.length(); i++) {
            char c = arr[i];
            for(char j = 'a' ; j <= 'z' ;j++) {
                if(j == c) continue;
                arr[i] = j;
                String newString = new String(arr);
                if(dict.contains(newString)) {
                    res.add(newString);
                    children.add(newString);
                }
            }
            arr[i] = c;
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
