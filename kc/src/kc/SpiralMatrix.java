package kc;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(matrix.length == 0 || matrix[0].length == 0) return res;
    	
    	int rowStart = 0;
    	int colStart = 0;
    	int rowEnd = matrix.length - 1;
    	int colEnd = matrix[0].length - 1;
    	
    	while(rowStart < rowEnd && colStart < colEnd) {
    		
    		//Add top
    		for(int i = colStart; i < colEnd; i++) {
    			res.add(matrix[rowStart][i]);
    		}
    		
    		//Add right
    		for(int i = rowStart; i < rowEnd; i++) {
    			res.add(matrix[i][colEnd]);
    		}
    		
    		//Add bottom
    		for(int i = colEnd; i > colStart; i--) {
    			res.add(matrix[rowEnd][i]);
    		}
    		
    		//Add left
    		for(int i = rowEnd; i > rowStart; i--) {
    			res.add(matrix[i][colStart]);
    		}
    		
    		rowStart++;
    		rowEnd--;
    		colStart++;
    		colEnd--;
    	}
        
    	if(rowStart == rowEnd && colStart == colEnd) {

    		res.add(matrix[rowStart][colStart]);

    	} else if(rowStart < rowEnd && colStart == colEnd) {

    		while(rowStart <= rowEnd) {

    			res.add(matrix[rowStart][colStart]);

    			rowStart++;

    		}

    	} else if(colStart < colEnd && rowStart == rowEnd){

    		while(colStart <= colEnd) {

    			res.add(matrix[rowStart][colStart]);

    			colStart++;

    		}

    	}
    	
    	return res;
    	
    	

    }
    
    
    
    public static void main(String[] args) {
    	int[][] matrix = new int[2][3];
    	
    	matrix[0][0] = 2;
    	matrix[0][1] = 5;
    	matrix[0][2] = 8;
    	
    	matrix[1][0] = 4;
    	matrix[1][1] = 0;
    	matrix[1][2] = -1;
    	

    	
    	SpiralMatrix sol = new SpiralMatrix();
    	System.out.println(sol.spiralOrder(matrix));
    	
    }
    
}
