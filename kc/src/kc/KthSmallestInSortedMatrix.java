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
    
    public int kthSmallest2(int[][] matrix, int k) {
        if(matrix.length == 0) return 0;
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low < high) {
            int mid = low + (high - low) / 2;
            int nr = getEqualOrSmallerThan(matrix, mid);
            if(nr >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private int getEqualOrSmallerThan(int[][] matrix, int target) {
        int res = 0;
        for(int i = 0 ; i < matrix[0].length; i++) {
            int cur = matrix.length - 1;
            while(cur >= 0 && matrix[cur][i] > target) cur--;
            res += cur + 1;
        }
        return res;
    }
}
