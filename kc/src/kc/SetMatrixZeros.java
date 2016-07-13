package kc;

public class SetMatrixZeros {
	
    public void setZeroes(int[][] matrix)
    {	
    	if(matrix.length == 0 || matrix[0].length == 0) return;
    	
    	int firstRow = 0;
    	int firstCol = 0;
    	
    	for(int i = 0 ; i < matrix.length ; i++){
    		for(int j = 0 ; j < matrix[0].length; j++){
    			if(matrix[i][j] == 0) {
    				if(i == 0) firstRow = 1;
    				if(j == 0) firstCol = 1;
    				matrix[0][j] = 0;
    				matrix[i][0] = 0;
    			}
    		}
    	}
    	
    	for(int i = 1; i < matrix.length; i++){
    		for(int j = 1; j < matrix[0].length; j++){
    			if(matrix[i][0] == 0 || matrix[0][j] == 0) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	
    	if(firstRow == 1) {
    		for(int i = 0 ; i < matrix[0].length; i++){
    			matrix[0][i] = 0;
    		}
    	}
    	
    	if(firstCol == 1) {
    		for(int i = 0; i < matrix.length; i++){
    			matrix[i][0] = 0;
    		}
    	}
    	
    	
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = new int[3][3];
		mat[1][1] = 0;
		
		mat[0][0] = 1;
		mat[0][1] = 1;
		mat[0][2] = 1;
		
		mat[1][0] = 1;
		//mat[0][1] = 1;
		mat[1][2] = 1;
		
		mat[2][0] = 1;
		mat[2][1] = 1;
		mat[2][2] = 1;
		
		for(int i = 0 ; i < mat.length; i++) {
			for(int j = 0 ; j < mat.length;j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
		
		SetMatrixZeros set = new SetMatrixZeros();
		set.setZeroes(mat);
		for(int i = 0 ; i < mat.length; i++) {
			for(int j = 0 ; j < mat.length;j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}

}
