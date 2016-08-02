package kc;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
	
	TrieNode root = new TrieNode(' ');
	
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        List<TrieNode> children = cur.children;
        boolean found = false;
        
        for(int i = 0 ; i < word.length(); i++) {
        	if(children.size() > 0) {
        		for(TrieNode child: children) {
        			if(child.val == word.charAt(i)) {
        				cur = child;
        				children = cur.children;
        				found = true;
        			}
        		}
        		if(found) {
        			found = false;
        		} else {
        			TrieNode newChild = new TrieNode(word.charAt(i));
        			children.add(newChild);
        			cur = newChild;
        			children = newChild.children;
        		}
        	} else {
        		TrieNode newChild = new TrieNode(word.charAt(i));
        		children.add(newChild);
        		cur = newChild;
        		children = newChild.children;
        	}
        }
        
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	if(word.length() == 0) return true;
    	return search(word, root);
    }
    
    private boolean search(String word, TrieNode root) {
        TrieNode cur = root;
        List<TrieNode> children = cur.children;
        boolean found = false;
        for(int i = 0; i < word.length(); i++) {
        	if(children.size() == 0) {
        		return false;
        	} else {
        		if(word.charAt(i) == '.') {
        			for(TrieNode child:children) {
        				if(search(word.substring(i+1), child)) return true;
        			}
        			return false;
        		}
        		
        		for(TrieNode child:children) {
        			if(child.val == word.charAt(i)) {
        				found = true;
        				cur = child;
        				children = cur.children;
        				break;
        			}
        		}
        		if(found) {
        			found = false;
        		} else {
        			return false;
        		}
        	}
        }
        return cur.isWord;
    }
    
    
    private class TrieNode {
    	List<TrieNode> children;
    	char val;
    	boolean isWord;
    	
    	public TrieNode(char x) {
    		val = x;
    		children = new ArrayList<TrieNode>();
    		isWord = false;
    	}
    }
    
    public static void main(String[] args) {
		WordDictionary x = new WordDictionary();
		
		x.addWord("bad");
		x.addWord("dad");
		x.addWord("mad");

		System.out.println(x.search("pad"));
		System.out.println(x.search("bad"));
		System.out.println(x.search(".ad"));
		System.out.println(x.search("b.."));

	}
    
}
