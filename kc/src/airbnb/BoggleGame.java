package airbnb;

/**
 * Two variations:
 * 1) char can be re-used
 * 2) char cannot be reused
 * 
 * question: given a dict and a board, find the path that has largest number of word in a dict
 */
// i followed the solution below, a little hard to understand at first but eventually you'll get it
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=214074
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=191416
// 小哥给的思路是double recursion，第一个function go through所有的position 如果这个position没有被visit过就call第二个function backtrack，
// backtrack function里面如果目前的prefix不是一个词，就考虑上下左右继续backtrack，如果是一个词，就call第一个function，
// 然后把这个词加到第一个function return的list里。为了加速搜索要用trie但trie写起来有点麻烦所以小哥就让写一个hashset里面有所有的prefix。时间有点久有点忘了但大概就是这样。。。
public class BoggleGame {
	
	// idea is this: seach in the trie for each position, when meeting a word, do two things: 1) increament the count and recurse from neighbors or
	// 2) keep the count the same and keep moving
	
	// references above have some stuff but the sol below is much more cleaner
	private TrieNode root = new TrieNode();
	private int max = 0;
	
	public int getMaxNrWordsFromPath(char[][] board, String[] dict) {
		buildTrie(root, dict);
		for(int i = 0 ; i < board.length; i++) {
			for(int j = 0 ; j < board[0].length; j++) {
				dfs(board, root, i, j, 0);
			}
		}
		return max;
	}

	private void dfs(char[][] board, TrieNode cur, int i, int j, int curSize) {
		if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length-1 || board[i][j] == ' ') return;
		if(cur.children[board[i][j] - 'a'] == null) return;
		cur = cur.children[board[i][j] - 'a'];
		char c = board[i][j];
		if(cur.isWord) {
			// keep the current word
			board[i][j] = ' ';
			cur.isWord = false; // if the question is to ask number of distinct words, then this is necessary, otherwise no.
			max = Math.max(max, curSize + 1);
			dfs(board, root, i+1,j, curSize + 1);
			dfs(board, root, i-1,j, curSize + 1);
			dfs(board, root, i, j+1, curSize + 1);
			dfs(board, root, i, j-1, curSize + 1);
			cur.isWord = true;
		}
		
		// not to keep
		dfs(board, cur, i + 1 , j , curSize);
		dfs(board, cur, i-1,j,curSize);
		dfs(board, cur, i, j+1, curSize);
		dfs(board, cur, i, j-1, curSize);
		

		board[i][j] = c;
	}


	private void buildTrie(TrieNode root, String[] dict) {
		TrieNode cur;
		for(String str : dict) {
			cur = root;
			for(char c : str.toCharArray()) {
				if(cur.children[c - 'a'] == null) cur.children[c-'a'] = new TrieNode();
				cur = cur.children[c-'a'];
			}
			cur.isWord = true;
		}
	}


	public class TrieNode {
		TrieNode[] children;
		boolean isWord;
		public TrieNode() {
			isWord = false;
			children = new TrieNode[26];
		}
	}

	
	
	// Test client
	public static void main(String[] args) {
		BoggleGame game = new BoggleGame();
		char[][] board = {{'a','b','c','a'},{'d','d','c','b'},{'b','b','d','s'}};
		String[] dict = {"abc", "abs","dd" ,"bb" ,"dc"};
		System.out.println(game.getMaxNrWordsFromPath(board, dict));
		
	}
}