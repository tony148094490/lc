package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(beginWord.equals(endWord)) return res;
        wordList.remove(beginWord);
        wordList.add(endWord);
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        Set<String> parents = new HashSet<String>();
        parents.add(beginWord);
        while(!parents.isEmpty()) {
            Set<String> currentChildren = new HashSet<String>();
            for(String p : parents) {
                Set<String> children = getNb(p, wordList);
                currentChildren.addAll(children);
                for(String child : children) {
                    if(!map.containsKey(child)) {
                        Set<String> set = new HashSet<String>();
                        set.add(p);
                        map.put(child, set);
                    } else {
                        map.get(child).add(p);
                    }
                    if(child.equals(endWord)) {
                        List<String> path = new ArrayList<String>();
                        path.add(0, endWord);
                        path.add(0, p);
                        getPath(p, map, path, res);   
                    }
                }

            }
            if(!res.isEmpty()) {
                return res;
            }
            wordList.removeAll(currentChildren);
            parents = currentChildren;
        }
        return res;
    }
    
    private Set<String> getNb(String parent, Set<String> dict) {
        Set<String> res = new HashSet<String>();
        char[] arr = parent.toCharArray();
        for(int i = 0 ; i < parent.length(); i++) {
            char temp = arr[i];
            for(char c = 'a' ; c <= 'z'; c++) {
                if(parent.charAt(i) == c) continue;
                arr[i] = c;
                String str = new String(arr);
                if(dict.contains(str)) res.add(str);
            }
            arr[i] = temp;
        }
        return res;
    }
    
    private void getPath(String parent, Map<String, Set<String>> existing, List<String> path,
                List<List<String>> res) {
            if(existing.containsKey(parent)) {
                for(String str : existing.get(parent)) {
                    path.add(0, str);
                    getPath(str, existing, path, res);
                    path.remove(0);
                }
            } else {
                res.add(new ArrayList<String>(path));
            }
    }
    
    public static void main(String[] args) {
    	Set<String> wordList = new HashSet<String>();
    	wordList.add("red");
    	wordList.add("ted");
    	wordList.add("tex");
    	wordList.add("tax");
    	wordList.add("tad");
    	wordList.add("den");
    	wordList.add("rex");
    	wordList.add("pee");
    
    	Set<String> wordList2 = new HashSet<String>();
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
