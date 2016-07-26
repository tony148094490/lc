package kc;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int c = 0;
        for(int i = 0 ; i < grid.length; i++){
        	for(int j = 0 ; j < grid[0].length; j++){
        		if(grid[i][j] == '0') continue;
        		c++;
        		dfs(grid,i,j);
        	}
        }
        return c;
    }
    
    private void dfs (char[][] grid, int r, int c) {
    	
    	if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
    	
    	if(grid[r][c] == '0') return;
    	
    	grid[r][c] = '0';
    	
    	dfs(grid,r-1,c);
    	dfs(grid,r+1,c);
    	dfs(grid,r,c-1);
    	dfs(grid,r,c+1);
    }
}
