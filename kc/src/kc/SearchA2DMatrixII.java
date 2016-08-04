package kc;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length == 0 || matrix[0].length == 0) return false;
    	if(matrix[0][0] > target || matrix[matrix.length-1][matrix[0].length-1] < target) return false;
        return helper(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
    }
    
    private boolean helper(int[][] matrix, int target, int rowLow, int rowHigh,
    		int colLow, int colHigh) {
    	if(rowLow > rowHigh || colLow > colHigh) return false;
    	
    	int rowMid = (rowLow + rowHigh) / 2;
    	int colMid = (colLow + colHigh) / 2;
    	
    	int mid = matrix[rowMid][colMid];
    	
    	if( mid == target) {
    		return true;
    	} 
  	
    	if( mid > target) {
    		boolean divid = false;
    		if(matrix[rowMid][colLow] > target) {
    			divid = helper(matrix,target, rowLow, rowMid-1,colLow, colHigh);
    			
    		} else if(matrix[rowMid][colLow] < target) {
    			divid = helper(matrix,target,rowLow,rowMid,colLow+1,colHigh);
    		} else {
    			return true;
    		}
    		if(divid) return true;
    		
    		return helper(matrix, target, rowMid+1, rowHigh, colLow, colMid-1);
    		
    	} else {
    		boolean divid = false;
    		if(matrix[rowHigh][colMid] > target) {
    			divid = helper(matrix,target, rowLow, rowHigh - 1, colMid, colHigh);
    		} else if(matrix[rowHigh][colMid] < target) {
    			divid = helper(matrix,target,rowLow, rowHigh, colMid+1, colHigh);
    		} else {
    			return true;
    		}
    		if(divid) return true;
    		    		
    		return helper(matrix,target, rowMid+1, rowHigh, colLow, colMid-1);
    	}
    	
    }
    
    public static void main(String[] args) {
		int[][] arr = new int[5][5];
		arr[0][0] = 1;
		arr[0][1] = 4;
		arr[0][2] = 7;
		arr[0][3] = 11;
		arr[0][4] = 15;
		
		arr[1][0] = 2;
		arr[1][1] = 5;
		arr[1][2] = 8;
		arr[1][3] = 12;
		arr[1][4] = 19;
		
		arr[2][0] = 3;
		arr[2][1] = 6;
		arr[2][2] = 9;
		arr[2][3] = 16;
		arr[2][4] = 22;
		
		arr[3][0] = 10;
		arr[3][1] = 13;
		arr[3][2] = 14;
		arr[3][3] = 17;
		arr[3][4] = 24;
		
		arr[4][0] = 18;
		arr[4][1] = 21;
		arr[4][2] = 23;
		arr[4][3] = 26;
		arr[4][4] = 30;
		SearchA2DMatrixII x = new SearchA2DMatrixII();
		System.out.println(x.searchMatrix(arr, 20));
		System.out.println(x.searchMatrix(arr, 5));
		
	}
}
