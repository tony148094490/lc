package kc;

public class TicTacToe {
    int[][] board;
    int[] rows1;
    int[] rows2;
    int[] cols1;
    int[] cols2;
    int[] dia1;
    int[] dia2;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        rows1 = new int[n];
        rows2 = new int[n];
        cols1 = new int[n];
        cols2 = new int[n];
        dia1 = new int[2];
        dia2 = new int[2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player == 1) {
        	rows1[row]++;
        	cols1[col]++;
        	if(row == col && row == board.length / 2) {
        		dia1[0]++;
        		dia1[1]++;
        	} else if(row == col) {
        		dia1[0]++;
        	} else if(row == board.length - col - 1) {
        		dia1[1]++;
        	}
        	if(rows1[row] == board.length || cols1[col] == board.length || dia1[0] == board.length || dia1[1] == board.length) {
        		return player;
        	}
        	return 0;
        } else {
        	rows2[row]++;
        	cols2[col]++;
        	if(row == col && row == board.length / 2) {
        		dia2[0]++;
        		dia2[1]++;
        	} else if(row == col) {
        		dia2[0]++;
        	} else if(row == board.length - col - 1) {
        		dia2[1]++;
        	}
        }
    	if(rows2[row] == board.length || cols2[col] == board.length || 
    			dia2[0] == board.length || dia2[1] == board.length) {
    		return player;
    	}
    	return 0;
    }  
}
