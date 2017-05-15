package kc;

import java.util.HashMap;
import java.util.Map;

public class LongestLineOfConsecutiveOneInMatrix {
    int max = 0;
    public int longestLine(int[][] M) {
        if(M.length == 0) return 0;
        int m = M.length;
        int n = M[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ; i < m; i++) {
            for(int j = 0 ; j < n;j++) {
                if(M[i][j] == 0) continue;
                Map<Integer, Integer> cur = dfs(M, i, j, visited, new boolean[m][n]);
                visited[i][j] = true;
            }
        }
        return max;
    }
    
    private Map<Integer, Integer> dfs(int[][] matrix, int i, int j, boolean[][] overall, boolean[][] visited) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0 || visited[i][j] || overall[i][j]) return new HashMap<>();
        
        visited[i][j] = true;
        Map<Integer, Integer> down = new HashMap<>();
        if(i == 0 || (i > 0 && overall[i-1][j] != true)) {
            down = dfs(matrix, i + 1, j ,overall, visited);
            max = Math.max(max, down.getOrDefault(1,0) + 1);
        }
        
        Map<Integer, Integer> right = new HashMap<>();
        if(j == 0 || (j > 0 && overall[i][j-1] != true)) {
            right = dfs(matrix, i, j+1, overall,visited);
            max = Math.max(max, right.getOrDefault(3,0) + 1);   
        }
        
        Map<Integer, Integer> downLeft = new HashMap<>();
        if(i == 0 || j == visited[0].length-1 || (i > 0 && j < visited[0].length-1 && overall[i-1][j+1] != true)) {
            downLeft = dfs(matrix, i +1 , j - 1, overall,visited);
            max = Math.max(max, downLeft.getOrDefault(6,0) + 1);
        }
        
        Map<Integer, Integer> downRight = new HashMap<>();
        if(i == 0 || j == 0 || (i > 0 && j > 0 && overall[i][j] != true)) {
            downRight = dfs(matrix, i + 1, j + 1,overall, visited);
            max = Math.max(max, downRight.getOrDefault(7,0) + 1);   
        }
        
        Map<Integer, Integer> res = new HashMap<>();
        
        res.put(1, down.getOrDefault(1,0) + 1);
        res.put(3, right.getOrDefault(3,0) + 1);
        res.put(6, downLeft.getOrDefault(6,0) + 1);
        res.put(7, downRight.getOrDefault(7,0) + 1);
        visited[i][j] = false;
        
        return res;
    }
    
    public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
}
