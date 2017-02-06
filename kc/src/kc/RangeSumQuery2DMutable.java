package kc;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its
 *  upper left corner (row1, col1) and lower right corner (row2, col2).
 * Example:
 *Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10

Note:
    The matrix is only modifiable by the update function.
    You may assume the number of calls to update and sumRegion function is distributed evenly.
    You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DMutable {
    int[][] matrix;
    int[][] rows;
    public RangeSumQuery2DMutable(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        this.matrix = matrix;
        rows = new int[matrix.length][matrix[0].length+1];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                rows[i][j+1] = rows[i][j] + matrix[i][j];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        for(int i = col; i < matrix[0].length; i++) {
            rows[row][i+1] = rows[row][i+1] - matrix[row][col] + val;
        }
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i = row1; i <= row2; i++) {
            res += (rows[i][col2+1] - rows[i][col1]);
        }
        return res;
    }
    
    public static void main(String[] args) {
    	int[][] matrix = new int[1][1];
    	matrix[0][0] = 1;
    	
        RangeSumQuery2DMutable x  = new RangeSumQuery2DMutable(matrix);
        System.out.println(x.sumRegion(0, 0, 0, 0));
        x.update(0, 0, -1);
        System.out.println(x.sumRegion(0, 0, 0, 0));
	}
}
//Your NumMatrix object will be instantiated and called as such:
//NumMatrix numMatrix = new NumMatrix(matrix);
//numMatrix.sumRegion(0, 1, 2, 3);
//numMatrix.update(1, 1, 10);
//numMatrix.sumRegion(1, 2, 3, 4);
