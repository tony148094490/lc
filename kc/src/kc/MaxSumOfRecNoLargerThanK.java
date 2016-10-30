package kc;

import java.util.TreeSet;

public class MaxSumOfRecNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
     int r = matrix.length;
     int c = matrix[0].length;
     int result = Integer.MIN_VALUE;
     for(int left = 0 ; left < c; left++) {
    	 int[] sums = new int[r];
    	 for(int right = left; right < c; right++) {
    		 for(int i = 0; i < r; i++) {
    			 sums[i] += matrix[i][right];
    		 }
    		 TreeSet<Integer> treeSet = new TreeSet<Integer>();
    		 treeSet.add(0);
    		 int currentSum = 0;
    		 for(int sum: sums) {
    			 currentSum += sum;
    			 Integer least = treeSet.ceiling(currentSum - k);
    			 if(least != null) result = Math.max(result, currentSum - least);
    			 if(result == k) return k;
    			 treeSet.add(currentSum);
    		 }
    	 }
     }
     return result;
    }
    
}
