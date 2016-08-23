package kc;

public class KthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length <= 0 || matrix[0].length <= 0 || k <= 0) return 0;
        int[] rows = new int[matrix.length];
        int counter = 0;
        while(counter < k) {
            int minimum = Integer.MAX_VALUE;
            int c = -1;
            int r = -1;
            for(int i = 0 ; i < rows.length; i++) {
                if(rows[i]>=matrix[0].length) continue;
                
                if(matrix[i][rows[i]] < minimum) {
                    c = rows[i];
                    r = i;
                    minimum = matrix[i][rows[i]];
                }
            }
            
            counter++;
            if(counter == k) {
                return matrix[r][c];
            }
            rows[r]++;
        }
        return 0;
    }
}
