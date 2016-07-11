package kc;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {

    	int rowStart = 0;
    	int rowEnd = n - 1;
    	int colStart = 0;
    	int colEnd = n - 1;
    	int v = 1;
    	int[][] res = new int[n][n];
    	
    	while(rowStart < rowEnd && colStart < colEnd) {
    	
    		for(int i = colStart; i < colEnd;i++){
    			res[rowStart][i] = v;
    			v++;
    		}
    		
    		for(int i = rowStart; i < rowEnd; i++){
    			res[i][colEnd] = v;
    			v++;
    		}
    		
    		for(int i = colEnd; i > colStart; i--) {
    			res[rowEnd][i] = v;
    			v++;
    		}
    		
    		for(int i = rowEnd; i > rowStart ; i--){
    			res[i][colStart] = v;
    			v++;
    		}
    		rowStart++;
    		rowEnd--;
    		colStart++;
    		colEnd--;
    	}
        if(rowStart == rowEnd) {
        	res[rowStart][colStart] = v;
        }
        return res;
    }
	
	public static void main(String[] args) {
		SpiralMatrixII sol = new SpiralMatrixII();
		int[][] arr = sol.generateMatrix(3);
		for(int i = 0 ; i < arr.length;i++){
			for(int j = 0; j < arr[i].length;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
