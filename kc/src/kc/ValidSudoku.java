package kc;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board.length < 3 || board[0].length < 3) return false;
        int[] checks = new int[board.length + 1];
        
        // check rows
        for(int i = 0 ; i < board.length; i++){
            checks = new int[board[0].length + 1];
            for(int j = 0 ; j < board[i].length; j++) {
                if(board[i][j] == '.') continue;
                int cur = board[i][j] - '0';
                if(checks[cur] != 0) return false;
                checks[cur] = 1;
            }
        }
        
        // check columns
        for(int i = 0 ; i < board.length; i++){
            checks = new int[board.length + 1];
            for(int j = 0 ; j < board[i].length; j++) {
                if(board[j][i] == '.') continue;
                int cur = board[j][i] - '0'; 
                if(checks[cur] != 0) return false;
                checks[cur] = 1;
            }
        }
        
        // check 9s
        for(int i = 0; i < board.length; i+=3) {
            for(int j = 0 ; j < board[0].length; j+=3) {
                checks = new int[board.length + 1];
                for(int k = i; k < i + 3; k++) {
                    for(int l = j; l < j + 3; l++) {
                        if(board[k][l] == '.') continue;
                        int cur = board[k][l] - '0';
                        if(checks[cur] != 0) return false;
                        checks[cur] = 1;
                    }
                }
            }
        }
        return true;
    }
}
