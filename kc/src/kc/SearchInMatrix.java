package kc;

public class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0, matrix.length - 1);
    }
    
    private boolean search(int[][] m, int target, int rowLow, int rowHigh) {
    	if(rowLow > rowHigh ) return false;
    	int i = (rowLow + rowHigh) / 2;
    	int j = (m[0].length - 1)/ 2;
    	
    	if(m[i][j] == target) {
    		return true;
    	} else if (m[i][j] < target) {
    		if(se(m,target, i, j, m[0].length - 1)) {
    			return true;
    		}
    		
    		return search(m,target,i+1,rowHigh);
    	} else {
    		if(se(m,target, i, 0, j)) return true;
    		
    		return search(m,target, rowLow, i-1);
    	}
    }
	
    private boolean se(int[][] m, int target, int row, int l, int r) {
    	if(l > r) return false;
    	
    	int mid = (l + r) / 2;
    	if(m[row][mid] == target) {
    		return true;
    	} else if(m[row][mid] < target) {
    		return se(m, target, row, mid + 1, r);
    	} else {
    		return se(m, target, row, l , mid - 1);
    	}
    }
    
	public static void main(String[] args) {
		int[][] mat = new int[3][3];		
		mat[0][0] = 1;
		mat[0][1] = 2;
		mat[0][2] = 3;
		
		mat[1][0] = 4;
		mat[1][1] = 6;
		mat[1][2] = 7;
		
		mat[2][0] = 8;
		mat[2][1] = 9;
		mat[2][2] = 10;
		
		for(int i = 0 ; i < mat.length; i++) {
			for(int j = 0 ; j < mat.length;j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
		
		SearchInMatrix x = new SearchInMatrix();
		
		System.out.println(x.searchMatrix(mat, 10));
	}

}
