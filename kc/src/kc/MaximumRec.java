package kc;

public class MaximumRec {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length; int n = matrix[0].length;
        int[][] cols = new int[m][n];
        int[][] rows = new int[m][n];
        int max = 0;
        for(int i = m-1; i >= 0; i--) {
            for(int j = n - 1; j >= 0 ; j--) {
                if(matrix[i][j] == '1') {
                    if(i == m-1) {
                        rows[i][j] = 1;
                    } else {
                        rows[i][j] = rows[i+1][j] + 1;
                    }
                    if(j == n - 1) {
                        cols[i][j] = 1;
                    } else {
                        cols[i][j] = cols[i][j+1] + 1;
                    }
                    max = Math.max(max, getMax(rows, cols, i, j));
                }
            }
        }
        return max;
    }
    
    private int getMax(int[][] rows, int[][] cols, int i, int j) {
        int currentRow = rows[i][j];
        int currentCol = cols[i][j];
        int max = Math.max(currentRow, currentCol);
        int minCol = cols[i][j];
        for(int k = 1 ; k < currentRow; k++) {
            minCol = Math.min(minCol, cols[i+k][j]);
            max = Math.max(max, minCol * (k+1));
        }
        return max;
    }
    
    
    public static void main(String[] args) {
		char[][] arr = new char[4][5];
		arr[0][0] = '1';
		arr[0][1] = '0';
		arr[0][2] = '1';
		arr[0][3] = '0';
		arr[0][4] = '0';
		
		arr[1][0] = '1';
		arr[1][1] = '1';
		arr[1][2] = '1';
		arr[1][3] = '1';
		arr[1][4] = '1';
		
		arr[2][0] = '1';
		arr[2][1] = '1';
		arr[2][2] = '1';
		arr[2][3] = '1';
		arr[2][4] = '1';
		
		arr[3][0] = '1';
		arr[3][1] = '0';
		arr[3][2] = '0';
		arr[3][3] = '1';
		arr[3][4] = '0';
		
		MaximumRec x= new MaximumRec();
		System.out.println(x.maximalRectangle(arr));
	}
}
