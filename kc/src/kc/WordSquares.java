package kc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if(words.length == 0) return res;
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        List<String> path = new ArrayList<>();
        for(String str : words) {
            path.add(str);
            dfs(str.length(), root, path, res);
            path.remove(path.size()-1);
        }
        return res;
    }
    
    private void dfs(int len, TrieNode root, List<String> path, List<List<String>> res) {
        if(path.size() == len) {
            res.add(new ArrayList<>(path));
        } else {
            int index = path.size();
            String prefix = "";
            for(String str : path) {
                prefix += str.charAt(index);
            }
            List<String> candidates = findByPrefix(root, prefix);
            for(String s : candidates) {
                path.add(s);
                dfs(len, root, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    
    private void buildTrie(TrieNode root, String[] words) {
        for(String str : words) {
            TrieNode cur = root;
            for(char c : str.toCharArray()) {
                if(cur.children[c-'a'] == null) cur.children[c-'a'] = new TrieNode();
                cur.children[c-'a'].startsWith.add(str);
                cur = cur.children[c-'a'];
            }
        }
    }
    
    private List<String> findByPrefix(TrieNode root, String prefix) {
        List<String> res = new ArrayList<>();
        TrieNode cur = root;
        for(char c : prefix.toCharArray()) {
            if(cur.children[c-'a'] == null) return res;
            cur = cur.children[c-'a'];
        }
        res.addAll(cur.startsWith);
        return res;
    }
    
    class TrieNode {
        List<String> startsWith;
        TrieNode[] children;
        TrieNode() {
            startsWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    
    public static void main(String[] args) {
    	Vector<String> vect = new Vector<String>();
    	Set<String> set = new HashSet<>(vect);
    }
    
}
