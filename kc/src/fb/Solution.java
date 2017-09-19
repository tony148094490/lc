package fb;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        List<List<Node>> aMat = new ArrayList<>();
        for(int i = 0 ; i < A.length; i++) {
            List<Node> aList = new ArrayList<>();
            for(int j = 0 ; j < A[0].length; j++) {
                Node n = new Node(i,j,A[i][j]);
                aList.add(n);
            }
            if(!aList.isEmpty())
            aMat.add(aList);
        }
        
        List<List<Node>> bMat = new ArrayList<>();
        for(int j = 0 ; j < B[0].length; j++) {
            List<Node> bList = new ArrayList<>();
            for(int i = 0 ; i < B.length; i++) {
                Node n = new Node(i, j, B[i][j]);
                bList.add(n);
            }
            if(!bList.isEmpty())
            bMat.add(bList);
        }
        
        int aIndex = 0;
        int bIndex = 0;
        int[][] res = new int[A.length][B[0].length];
        while(aIndex<aMat.size()&&bIndex<bMat.size()) {
            List<Node> aList = aMat.get(aIndex);
            List<Node> bList = bMat.get(bIndex);
            if(aList.get(0).y == bList.get(0).x) {
                for(int i = 0 ; i < aList.size();i++) {
                    for(int j = 0 ; j < bList.size(); j++) {
                        int x = aList.get(i).x;
                        int y = bList.get(j).y;
                        int v = aList.get(i).v * bList.get(j).v;
                        res[x][y] += v;
                    }
                }
                aIndex++;
                bIndex++;
            } else if(aList.get(0).y < bList.get(0).x) {
                aIndex++;
            } else {
                bIndex++;
            }
        }
        return res;
    }
    
    public class Node {
        int x;
        int y;
        int v;
        public Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
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
    	
    	Solution x = new Solution();
    	int[][] res = x.multiply(A, B);
    	for(int i = 0 ; i < res.length; i++) {
    		for(int j =0 ; j < res[0].length; j++) {
    			System.out.print(res[i][j] + ",");
    		}
    		System.out.println();
    	}
	}
}
