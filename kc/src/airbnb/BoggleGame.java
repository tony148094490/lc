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
		if(dict == null || board == null || dict.length == 0 || board.length == 0) return 0; // discuss output with interviewer
		buildTrie(dict, this.root);
		for(int i = 0 ; i < board.length; i++) {
			for(int j = 0 ; j < board[0].length; j++) {
				search(board,i,j,root,0, new boolean[board.length][board[0].length]);
			}
		}
		return max;
	}
	
	private void search(char[][] board, int i, int j, TrieNode curRoot, int count, boolean[][] visited) {
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
		
		if(visited[i][j]) return;
		
		if(curRoot.children[board[i][j] - 'a'] == null) return;
		
		visited[i][j] = true;
		
		curRoot = curRoot.children[board[i][j] - 'a'];
		
		if(curRoot.isWord) {
			curRoot.isWord = false; // this is the tricky part, so that this word can not be counted again, backtracking
			max = Math.max(max, count + 1);
			search(board, i+1,j,this.root,count+1,visited); // search from the top of the trie again
			search(board, i-1,j,this.root,count+1,visited); // search from the top of the trie again
			search(board, i,j+1,this.root,count+1,visited); // search from the top of the trie again
			search(board, i,j-1,this.root,count+1,visited); // search from the top of the trie again
			curRoot.isWord = true;
		}
		
		search(board,i+1,j,curRoot, count, visited);
		search(board,i-1,j,curRoot, count, visited);
		search(board,i,j+1,curRoot, count, visited);
		search(board,i,j-1,curRoot, count, visited);
		
		visited[i][j] = false;
	}
	
	private void buildTrie(String[] dict, TrieNode root) {
		
		for(String str : dict) {
			TrieNode cur = root;
			for(int i = 0 ; i < str.length(); i++) {
				int index = str.charAt(i) - 'a';
				if(cur.children[index] == null) {
					cur.children[index] = new TrieNode();
				}
				cur = cur.children[index];
			}
			cur.isWord = true;
		}
	}
	
	public class TrieNode {
		TrieNode[] children = new TrieNode[26]; // only lower case, needs to discuss
		boolean isWord = false;
	}
	
	
	// Test client
	public static void main(String[] args) {
		BoggleGame game = new BoggleGame();
		char[][] board = {{'a','b','c','a'},{'d','d','c','b'},{'b','b','d','s'}};
		String[] dict = {"abc", "abs","dd" ,"bb" ,"dc"};
		System.out.println(game.getMaxNrWordsFromPath(board, dict));
		
	}
}