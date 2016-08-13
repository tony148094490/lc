package kc;

public class NumMatrix {
	int[][] dp;
    public NumMatrix(int[][] matrix) {
    	if(matrix.length == 0) return;
        dp = new int[matrix.length][matrix[0].length+1];
        
        for(int i = 0 ; i < matrix.length; i++) {
        	for(int j = 0 ; j < matrix[0].length;j++){
        			dp[i][j+1] = matrix[i][j] + dp[i][j];
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
    	for(int i = row1; i <= row2; i++) {
        	res += (dp[i][col2+1] - dp[i][col1]);
        }
    	return res;
    }
    public static void main(String[] args) {
    	int[][] matrix = new int[5][5];
    	matrix[0][0] = 3;
    	matrix[0][1] = 0;
    	matrix[0][2] = 1;
    	matrix[0][3] = 4;
    	matrix[0][4] = 2;

    	matrix[1][0] = 5;
    	matrix[1][1] = 6;
    	matrix[1][2] = 3;
    	matrix[1][3] = 2;
    	matrix[1][4] = 1;

    	matrix[2][0] = 1;
    	matrix[2][1] = 2;
    	matrix[2][2] = 0;
    	matrix[2][3] = 1;
    	matrix[2][4] = 5;
    	
    	matrix[3][0] = 4;
    	matrix[3][1] = 1;
    	matrix[3][2] = 0;
    	matrix[3][3] = 1;
    	matrix[3][4] = 7;

    	matrix[4][0] = 1;
    	matrix[4][1] = 0;
    	matrix[4][2] = 3;
    	matrix[4][3] = 0;
    	matrix[4][4] = 5;

    	
    	NumMatrix x = new NumMatrix(matrix);
    	System.out.println(x.sumRegion(1, 2, 2, 4));
    	
    	
	}
}
