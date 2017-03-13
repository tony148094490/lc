package kc;

public class BombEmney {
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0) return 0;
        int res = 0;
        
        int[] cols = new int[grid[0].length];
        
        for(int i = 0 ; i < grid.length; i++) {
            int row = 0;
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 'W') continue;
                
                if((j == 0) || (j > 0 && (grid[i][j-1] == 'W'))) {
                    row = getRow(grid, i, j);
                }
                
                if((i == 0) || (i > 0 && (grid[i-1][j] == 'W'))) {
                    cols[j] = getCol(grid, i, j);
                }
                
                if(grid[i][j] == '0')
                res = Math.max(res, row + cols[j]);
            }
        }
        return res;
    }
    
    private int getRow(char[][] grid, int i, int j) {
    	int res = 0;
    	while(j < grid[0].length && grid[i][j] != 'W') {
    		if(grid[i][j] == 'E') res++;
    		j++;
    	}
    	return res;
    }
    private int getCol(char[][] grid, int i, int j) {
    	int res = 0;
    	while(i < grid.length && grid[i][j] != 'W') {
    		if(grid[i][j] == 'E') res++;
    		i++;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		char[][] grid = new char[3][4];
		grid[0][0] = '0';
		grid[0][1] = 'E';
		grid[0][2] = '0';
		grid[0][3] = '0';
		grid[1][0] = 'E';
		grid[1][1] = '0';
		grid[1][2] = 'W';
		grid[1][3] = 'E';
		grid[2][0] = '0';
		grid[2][1] = 'E';
		grid[2][2] = '0';
		grid[2][3] = '0';
		BombEmney x = new BombEmney();
		System.out.println(x.maxKilledEnemies(grid));
		
	}
}
