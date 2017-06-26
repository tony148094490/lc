package airbnb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    TrieNode root = new TrieNode();
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(words.length == 0 || board.length == 0 || board[0].length == 0) return res;
        buildTrie(words);
        Set<String> visited = new HashSet<String>();
        for(int i = 0 ; i < board.length; i++) {
            for(int j = 0 ; j < board[0].length; j++) {
                helper(board, i, j, res, root, "", visited);
            }
        }
        return res;
    }
    
    private void helper(char[][] board, int i, int j, List<String> res, TrieNode root, String cur, Set<String> visited) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == ' ') {
            return;
        }
        
        char c = board[i][j];
        if(root.children[c-'a'] == null) return;
        cur += c;
        if(root.children[c-'a'].isWord && !visited.contains(cur)) {
            res.add(cur);
            visited.add(cur);
        }
        board[i][j] = ' ';
        helper(board, i-1,j,res,root.children[c-'a'], cur, visited);
        helper(board, i+1,j,res,root.children[c-'a'], cur, visited);
        helper(board, i,j-1,res,root.children[c-'a'], cur, visited);
        helper(board, i,j+1,res,root.children[c-'a'], cur, visited);
        board[i][j] = c;
    }
    
    private void buildTrie(String[] words) {
        for(String str : words)
            insert(root, str);
    }
    
    private void insert(TrieNode root, String str) {
        TrieNode cur = root;
        for(int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            if(cur.children[c-'a'] == null) cur.children[c-'a'] = new TrieNode();
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }
    
    private class TrieNode {
    	boolean isWord;
    	TrieNode[] children = new TrieNode[26];
    }
}
