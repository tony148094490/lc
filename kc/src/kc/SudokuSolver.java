package kc;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    for(char k = '1' ; k <='9'; k++) {
                        boolean solved = false;
                        if(isValid(board, i, j, k)) {
                            board[i][j] = k;
                            solved = solve(board);
                        }
                        if(solved) {
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int r, int c, char value) {
        // check row
        for(int i = 0; i < 9; i++) {
            if(board[i][c] == value) return false;
        }
        
        // check column
        for(int i = 0 ; i < 9; i++) {
            if(board[r][i] == value) return false;
        }
        
        r = ( (r) / 3) * 3;
        c = ( (c) / 3) * 3;
        for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++ ){
                if(board[i][j] == value) return false;
            }
        }
        return true;
    }
}
