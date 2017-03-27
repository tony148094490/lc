package kc;

import java.util.HashMap;
import java.util.Map;

/**
 * A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]
B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]
     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
    	if(A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0) return null;
        int[][] res = new int[A.length][B[0].length];
        for(int i = 0 ; i < A.length; i++) {
        	for(int j = 0 ; j < A[0].length; j++) {
        		if(A[i][j] == 0) continue;
        		for(int k = 0 ; k < B[0].length; k++) {
        			if(B[j][k] != 0) {
        				res[i][k] += A[i][j] * B[j][k];
        			}
        		}
        	}
        }
        return res;
    }
    
    public int[][] multiply2(int[][] A, int[][] B) {
        if(A.length == 0 || B.length == 0) return null;
        
        int[][] res = new int[A.length][B[0].length];
        
        Map<Integer, Map<Integer, Integer>> mapA = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();

        for(int i = 0 ; i < A.length; i++) {
            for(int j = 0 ; j < A[0].length; j++) {
                if(A[i][j] != 0) {
                    if(!mapA.containsKey(i)) mapA.put(i, new HashMap<>());
                    mapA.get(i).put(j, A[i][j]);
                }
            }
        }
        
        for(int i = 0 ; i < B.length; i++) {
            for(int j = 0 ; j < B[0].length; j++) {
                if(B[i][j] != 0) {
                    if(!mapB.containsKey(i)) mapB.put(i, new HashMap<>());
                    mapB.get(i).put(j, B[i][j]);
                }
            }
        }
        
        for(Integer i : mapA.keySet()) {
            for(Integer j : mapA.get(i).keySet()) {
                if(!mapB.containsKey(j)) {
                    continue;
                }
                for(Integer k : mapB.get(j).keySet()) {
                    res[i][k] += mapA.get(i).get(j) * mapB.get(j).get(k);
                }
            }
        }
        return res;
    }
    
    
    
    public static void main(String[] args) {
    	int[][] A = new int[2][3];
    	A[0][0] = 1;
    	A[0][1] = 0;
    	A[0][2] = 0;
    	A[1][0] = -1;
    	A[1][1] = 0;
    	A[1][2] = 3;
    	
    	int[][] B = new int[3][3];
    	B[0][0] = 7;
    	B[0][1] = 0;
    	B[0][2] = 0;
    	B[1][0] = 0;
    	B[1][1] = 0;
    	B[1][2] = 0;
    	B[2][0] = 0;
    	B[2][1] = 0;
    	B[2][2] = 1;
    	
    	SparseMatrixMultiplication x = new SparseMatrixMultiplication();
    	int[][] res = x.multiply(A, B);
    	for(int i = 0 ; i < res.length; i++) {
    		for(int j =0 ; j < res[0].length; j++) {
    			System.out.print(res[i][j] + ",");
    		}
    		System.out.println();
    	}
    	
    }
}
