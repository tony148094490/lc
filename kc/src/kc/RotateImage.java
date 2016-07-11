package kc;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
    	//rotate squre(s) from outer most layer to inner most layer
    	for(int i = 0 ; i < matrix.length/2 ;i++) {
    		rotateSquare(matrix,i);
    	}
    	
    }
    
    private void rotateSquare(int[][] matrix, int depth) {
    	int end = matrix[0].length - 1 - depth;
    	int length = matrix.length;
    	int[] temp = new int[length];
    	
    	// store left side
    	for(int i = depth; i < end; i++) {
    		temp[i] = matrix[length - 1 - i][depth];
    	}
    	
    	//populate left side
    	for(int i = depth; i < end; i++) {
    		matrix[length - 1 - i][depth] = matrix[length - 1 - depth][length - 1 - i];
    	}
    	
    	//populate bottom side
    	for(int i = depth; i < end; i++) {
    		matrix[length - 1 - depth][length - 1 - i] = matrix[i][length - 1 - depth];
    	}
    	
    	//populate right side
    	for(int i = depth; i < end; i++) {
    		matrix[i][length-1-depth] = matrix[depth][i];
    	}
    	
    	//populate top side
    	for(int i = depth; i < end; i++) {
    		matrix[depth][i] = temp[i];
    	}
    }
    
	public static void main(String[] args) {
		int[][] res = new int[4][4];
		int x = 0;
		for(int i = 0; i < res.length;i++) {
			for(int j = 0; j < res[0].length; j++) {
				res[i][j] = x;
				x++;
			}
		}
		
		for(int i = 0; i < res.length;i++) {
			for(int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + ",");
			}
			System.out.println();
		}
		
		
		
		RotateImage a = new RotateImage();
		a.rotate(res);
		System.out.println();
		
		for(int i = 0; i < res.length;i++) {
			for(int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + ",");
			}
			System.out.println();
		}
	}

}
