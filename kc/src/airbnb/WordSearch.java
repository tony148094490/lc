package airbnb;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        for(int i = 0 ; i < board.length; i++) {
        	for(int j = 0 ; j < board[0].length ; j++) {
        		if(helper(board,0,i,j,word)) return true;
        	}
        }
        return false;
    }
    
    private boolean helper(char[][] board, int curIndex, int curRow, int curCol, String word) {
    	if(curIndex == word.length()) return true;
    	
    	if(curRow < 0 || curRow >= board.length || curCol < 0 || curCol >= board[0].length) return false;
    	
    	if(board[curRow][curCol] != word.charAt(curIndex)) return false;
    	
    	char temp = board[curRow][curCol];
    	board[curRow][curCol] = ' ';
    	boolean res = helper(board,curIndex+1,curRow+1,curCol,word) ||
    			helper(board,curIndex+1,curRow,curCol+1,word) || helper(board,curIndex+1,curRow-1,curCol,word)
    			|| helper(board,curIndex+1,curRow,curCol-1,word);
    	board[curRow][curCol] = temp;
    	return res;
    }
    
    public static void main(String[] args) {
    	char[][] arr = new char[4][4];
    	arr[0][0] = 'A';
    	arr[0][1] = 'B';
    	arr[0][2] = 'C';
    	arr[0][3] = 'E';
    	arr[1][0] = 'S';
    	arr[1][1] = 'F';
    	arr[1][2] = 'C';
    	arr[1][3] = 'S';
    	arr[2][0] = 'A';
    	arr[2][1] = 'D';
    	arr[2][2] = 'E';
    	arr[2][3] = 'E';
    	arr[3][0] = 'A';
    	arr[3][1] = 'A';
    	arr[3][2] = 'A';
    	arr[3][3] = 'A';
    	WordSearch w = new WordSearch();
    	System.out.println(w.exist(arr, "ABCB"));
    }
	
}
