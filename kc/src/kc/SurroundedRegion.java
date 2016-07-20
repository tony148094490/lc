package kc;

public class SurroundedRegion {
    public void solve(char[][] board) {
    	if(board.length <= 2 || board[0].length <= 2) return;
    	
    	//dfs up and down
    	for(int i = 0; i < board[0].length;i++){
    		if(board[0][i] == 'O') {
    			dfs(board,0,i);
    		}    		
    		if(board[board.length-1][i] == 'O') {
    			dfs(board,board.length-1,i);
    		}
    	}
    	
    	//dfs left and right
    	for(int i = 0 ; i < board.length; i++){
    		if(board[i][0] == 'O') {
    			dfs(board,i,0);
    		}   		
    		if(board[i][board[0].length-1] == 'O') {
    			dfs(board,i,board[0].length-1);
    		}
    	}

    	for(int i = 0 ; i < board.length; i++){
    		for(int j = 0 ; j < board[0].length; j++){
    			if(board[i][j] == '#') {
    				board[i][j] = 'O';
    			} else if(board[i][j] == 'O') {
    				board[i][j] = 'X';
    			}
    		}
    	}
    }
    
    private void dfs(char[][]board, int i, int j) {
    	if(i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1) return;
    	
    	if(board[i][j] == 'O') {
    		board[i][j] = '#';
    		if(i>1)
    		dfs(board,i-1,j);
    		
    		if(i<board.length-1)
    		dfs(board,i+1,j);
    		
    		if(j>1)
    		dfs(board,i,j-1);
    		
    		if(j<board[0].length-1)
    		dfs(board,i,j+1);
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
