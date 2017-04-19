package kc;

public class SurroundedRegion {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        if(board.length == 0) return;
        for(int i = 0 ; i < board.length; i++) {
            if(board[i][0] == 'O') getEdge(board, i, 0);
            if(board[i][board[0].length-1] == 'O') getEdge(board, i, board[0].length-1);
        }
        
        for(int j = 0 ; j < board[0].length; j++) {
            if(board[0][j] == 'O') getEdge(board, 0, j);
            if(board[board.length-1][j] == 'O') getEdge(board, board.length-1, j);
        }
        
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'B') board[i][j] = 'O';
            }
        }
    }
    
    private void getEdge(char[][] board, int i, int j) {
        board[i][j] = 'B';
        for(int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni < 1 || ni >= board.length - 1 || nj < 1 || nj >= board[0].length - 1 || board[ni][nj] != 'O') continue;
            getEdge(board, ni, nj);
        }
    }
    
    public static void main(String[] args) {
    	SurroundedRegion x = new SurroundedRegion();
    	char[][] arr = new char[4][4];
    	arr[0][0] = 'X';
    	arr[0][1] = 'X';
    	arr[0][2] = 'X';
    	arr[0][3] = 'X';
    	
    	arr[1][0] = 'X';   	
    	arr[1][1] = 'O';
    	arr[1][2] = 'O';
    	arr[1][3] = 'X';
    	
    	arr[2][0] = 'X';
    	arr[2][1] = 'O';
    	arr[2][2] = 'X';
    	arr[2][3] = 'X';
    	
    	arr[3][0] = 'X';
    	arr[3][1] = 'O';
    	arr[3][2] = 'X';
    	arr[3][3] = 'X';
    	
    	for(int i = 0; i < arr.length; i++){
    		for(int j = 0 ;j < arr[0].length;j++){
    			System.out.print(arr[i][j]);
    		}System.out.println();
    	}
    	x.solve(arr);
    	System.out.println();
    	for(int i = 0; i < arr.length; i++){
    		for(int j = 0 ;j < arr[0].length;j++){
    			System.out.print(arr[i][j]);
    		}System.out.println();
    	}
    }
}
