package kc;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        for(int i = 0 ; i < board.length ; i++ ) {
        	for(int j = 0 ; j < board[0].length; j++) {
        		int ones = getNumberOfOnes(board,i,j);
        		System.out.print(ones);
        		if(board[i][j] == 1) {
        			if(ones < 2 || ones > 3) {
        				board[i][j] = -1;
        			}
        		} else {
        			if(ones == 3) {
        				board[i][j] = 2;
        			}
        		}
        	}
        	System.out.println();
        }
        
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0 ; j < board[0].length;j++) {
        		if(board[i][j] == -1) {
        			board[i][j] = 0;
        		}else if(board[i][j] == 2) {
        			board[i][j] = 1;
        		}
        	}
        }
    }
    
    private int getNumberOfOnes(int[][] board, int i, int j) {
    	int res = 0;
    	// get north
    	if(i>0) res = (board[i-1][j] != 0 && board[i-1][j] != 2) ? res + 1 : res;
    	// get north east
    	if(j<board[0].length - 1 && i > 0) res = (board[i-1][j+1] != 0 && board[i-1][j+1] != 2) ? res+1:res;
    	// get east;
    	if(j<board[0].length - 1) res = (board[i][j+1] != 0 && board[i][j+1] != 2) ? res+1:res;
    	// get south east
    	if(i < board.length - 1 && j < board[0].length - 1) res = (board[i+1][j+1] != 0 && board[i+1][j+1] != 2) ? res+1:res;
    	// get south
    	if(i < board.length -1 ) res = (board[i+1][j] != 0 && board[i+1][j] != 2) ? res+1:res;
    	// get south west
    	if(j > 0 && i < board.length - 1) res = (board[i+1][j-1] != 0 && board[i+1][j-1] != 2) ? res+1:res;
    	// get west
    	if(j > 0) res = (board[i][j-1] != 0 && board[i][j-1] != 2) ? res+1 : res;
    	// get north west
    	if(i>0 && j > 0) res = (board[i-1][j-1] != 0 && board[i-1][j-1]!=2 ) ? res+1:res;
    	return res;
    }

    public static void main(String[] args) {
    	GameOfLife x = new GameOfLife();
    	
    	int[][] arr = new int[3][6];
    	arr[0][0] = 1;
    	arr[0][1] = 0;
    	arr[0][2] = 1;
    	arr[0][3] = 0;
    	arr[0][4] = 1;
    	arr[0][5] = 0;
    	
    	arr[1][0] = 1;
    	arr[1][1] = 0;
    	arr[1][2] = 1;
    	arr[1][3] = 0;
    	arr[1][4] = 0;
    	arr[1][5] = 1;
    	
    	arr[2][0] = 1;
    	arr[2][1] = 0;
    	arr[2][2] = 0;
    	arr[2][3] = 1;
    	arr[2][4] = 0;
    	arr[2][5] = 0;
    	
    	x.gameOfLife(arr);
    	System.out.println(x.getNumberOfOnes(arr, 1, 0));
    	
    	for(int i = 0 ;i < arr.length; i++){
    		for(int j = 0 ; j < arr[0].length; j++){
    			System.out.print(arr[i][j] + ",");
    		}
    		System.out.println();
    	}
	}
    
}
