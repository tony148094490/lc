package kc;

public class MaximalSqure {
    public int maximalSquare(char[][] matrix) {
    	if(matrix.length == 0 || matrix[0].length == 0) return 0;
    	
int max = 0;

for(int i = 0 ; i < matrix.length; i++) {
	for(int j = 0 ;j < matrix[0].length; j++) {
		if(matrix[i][j] == '0') continue;
		
		int layer = 1;
		boolean isVertical = true;
		boolean isHorizontal = true;
		while(isVertical && isHorizontal && (i+layer<matrix.length) && (j+layer<matrix[0].length)) { 
			isVertical = false;
			isHorizontal = false;
			//vertical
			for(int k = i; k <= i + layer - 1; k++) {	
				if(matrix[k][j+layer] == '0') {
					isVertical = false;
					break;
				} else {
					isVertical = true;
				}
			}
			if(isVertical == false) break;	
			//horizontal	
			for(int k = j; k <= j + layer; k++) {
				if(matrix[i+layer][k] == '0') {
					isHorizontal = false;
					break;
				} else {
					isHorizontal = true;
				}
			}
			
			if(isHorizontal){
				layer++;
			}
		}
		
		max = Math.max(max, layer * layer);
		
	}
}
return max;
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
