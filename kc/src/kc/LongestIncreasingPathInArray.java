package kc;


public class LongestIncreasingPathInArray {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        Integer[][] prior = new Integer[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix.length; i++) {
        	for(int j = 0 ; j < matrix[0].length; j++) {
        		max = Math.max(dfs(matrix,i,j,null,
        				new boolean[matrix.length][matrix[0].length], prior), max);
        	}
        }  
        return max;
    }
    
    private Integer dfs(int[][] matrix, int i, int j, Integer previous,
    		boolean[][] visited, Integer[][] prior) {

    	if(i< 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {   		
    		return new Integer(0);
    	}  	
    	
    	if(visited[i][j]) {
    		return new Integer(0);
    	}
    	
    	if(previous != null && matrix[i][j] <= previous)  {
    		return new Integer(0);
    	}
    	
    	if(prior[i][j] != null) {
    		return new Integer(prior[i][j]);
    	}
    	
    	previous = matrix[i][j];
    	visited[i][j] = true;
    	
    	int left = dfs(matrix, i, j-1, previous, visited, prior);
    	int right = dfs(matrix, i, j+1, previous, visited, prior);
    	int up = dfs(matrix, i-1, j, previous, visited, prior);
    	int down = dfs(matrix, i+1, j, previous, visited, prior);
    	
    	visited[i][j] = false;
    	
    	prior[i][j] = new Integer(Math.max(left, Math.max(right, Math.max(up,down)))) + 1;
    	
    	return prior[i][j];
    }
    
    public static void main(String[] args) {
    	LongestIncreasingPathInArray x = new LongestIncreasingPathInArray();
    	int[][] nums = new int[3][3];
    	nums[0][0] = 9;
    	nums[0][1] = 9;
    	nums[0][2] = 4;
    	
    	nums[1][0] = 6;
    	nums[1][1] = 6;
    	nums[1][2] = 8;
    	
    	nums[2][0] = 2;
    	nums[2][1] = 1;
    	nums[2][2] = 1;
    	for(int i = 0; i < nums.length ;i++) {
    		for(int j = 0; j < nums[0].length; j++) {
    			System.out.print(nums[i][j] + ",");
    		}
    		System.out.println();
    	}
    	
    	System.out.println(x.longestIncreasingPath(nums));
    }
}
