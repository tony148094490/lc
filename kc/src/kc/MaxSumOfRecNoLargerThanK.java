package kc;

import java.util.TreeSet;

public class MaxSumOfRecNoLargerThanK {
    // idea is to move forward on columns and scan vertically. use treeset to get 'closest' point in each iteration
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < col; i++) {
            int[] rowSums = new int[row];
            for(int j = i ; j < col; j++) {
                for(int m = 0 ; m < row ; m++) {
                    rowSums[m] += matrix[m][j];
                }
                int curSum = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);// include all elements from top down to current sum, a range sum concept
                for(int sum : rowSums) {
                    curSum += sum;
                    Integer leastPreviousSum = set.ceiling(curSum - k);
                    if(leastPreviousSum != null) res = Math.max(res, (curSum - leastPreviousSum));
                    if(res == k) return k;
                    set.add(curSum);
                }
            }
        }
        return res;
    }
    
}
