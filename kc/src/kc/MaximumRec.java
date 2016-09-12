package kc;

public class MaximumRec {
	public int maximalRectangle(char[][] matrix) {
    	if(matrix.length == 0 || matrix[0].length == 0) return 0;
    	
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] cols = new int[row][col];
        int[][] rows = new int[row][col];
        
        int max = 0;
        for(int i = row - 1 ; i >= 0; i--) {
        	for(int j = col - 1 ; j >= 0; j--) {
        		if(matrix[i][j] == '0') {
        			cols[i][j] = 0;
        			rows[i][j] = 0;
        		} else {
        			if(j == col - 1) {
        				cols[i][j] = 1;
        			} else {
        				cols[i][j] = cols[i][j+1] + 1;
        			}
        			if(i == row - 1) {
        				rows[i][j] = 1;
        			} else {
        				rows[i][j] = rows[i+1][j] + 1;
        			}
        		}
        		
        		max = Math.max(max, getMaxRec(rows, cols, i, j));
        		
        	}
        }
        
        return max;
    }
    
    private int getMaxRec(int[][] rows, int[][] cols, int i, int j) {
    	int max = 0;
    	int singleCol = cols[i][j];
    	int singleRow = rows[i][j];
    	max = Math.max(singleCol, singleRow);
    	int minCol = singleCol;
    	for(int s = i; s < i + singleRow; s++) {
    		minCol = Math.min(minCol, cols[s][j]);
    		max = Math.max(max, (s - i + 1) * minCol);
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
