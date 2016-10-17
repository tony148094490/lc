package kc;

import java.util.ArrayList;
import java.util.List;

public class WorkdSearchII {
    public List<String> findWords(char[][] board, String[] words) {
    	List<String> res = new ArrayList<String>();
    	
    	TrieNode trie = buildTrie(words);
    	
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0 ; j < board[0].length; j++) {
    			contains(board, i, j, trie, res);
    		}
    	}
    	return res;
    }
    
    private void contains(char[][] board, int r, int c, TrieNode root, List<String> res) {
        
        
        if(board[r][c] == ' ' || root.next[board[r][c] - 'a'] == null) return;
        
        root = root.next[board[r][c] - 'a'];
    	if(root.word != null) {
    		res.add(root.word);
    		root.word = null;
    	}
    	
    	char temp = board[r][c];
    	board[r][c] = ' ';
    	if(r>0) contains(board,r-1,c,root, res);
    	if(r< board.length-1) contains(board,r+1,c,root, res);
    	if(c>0) contains(board,r,c-1,root, res);
    	if(c<board[0].length-1) contains(board,r,c+1,root, res);
    	board[r][c] = temp;
    	;
    }
    
    private TrieNode buildTrie(String[] words) {
    	TrieNode root = new TrieNode();
    	for(String str : words) {
    		TrieNode cur = root;
    		for(char c : str.toCharArray()) {
    			int index = c - 'a';
    			if(cur.next[index] == null) {
    				cur.next[index] = new TrieNode();
    			}
    			cur = cur.next[index];
    		}
    		cur.word = str;
    	}
    	return root;
    }
    
    private class TrieNode {
    	String word;
    	TrieNode[] next = new TrieNode[26];
    }
}
