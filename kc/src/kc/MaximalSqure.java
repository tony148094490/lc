package kc;

public class MaximalSqure {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int res = 0;
        for(int i = 0 ; i < matrix.length;i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') continue;
                dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1])) + 1;
                res = Math.max(res, dp[i+1][j+1]);
            }
        }
        return res * res;
    }
    
    public static void main(String[] args) {
    	MaximalSqure x = new MaximalSqure();
    	char[][] arr = new char[5][4];
    	arr[0][0] = '0';
    	arr[0][1] = '0';
    	arr[0][2] = '0';
    	arr[0][3] = '1';

    	arr[1][0] = '1';
    	arr[1][1] = '1';
    	arr[1][2] = '0';
    	arr[1][3] = '1';
    	
    	arr[2][0] = '1';
    	arr[2][1] = '1';
    	arr[2][2] = '1';
    	arr[2][3] = '1';
    	
    	arr[3][0] = '0';
    	arr[3][1] = '1';
    	arr[3][2] = '1';
    	arr[3][3] = '1';

    	arr[4][0] = '0';
    	arr[4][1] = '1';
    	arr[4][2] = '1';
    	arr[4][3] = '1';
    	
    	System.out.println(x.maximalSquare(arr));
	}
}
