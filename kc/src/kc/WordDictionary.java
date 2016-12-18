package kc;


public class WordDictionary {
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0 ; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }
    
    private boolean search(String word, TrieNode node) {
        TrieNode cur = node;
        boolean res = false;
        for(int i = 0 ; i < word.length() ; i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode n : cur.children) {
                    if( n != null) {
                        res |= search(word.substring(i+1), n);
                    }
                }
                return res;
            } else {
                if(cur.children[c-'a'] == null) return false;
                cur = cur.children[c-'a'];
            }
        }
        
        return cur.isWord;
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
