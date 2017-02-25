package kc;


public class AndroidUnlockPatterns {

	public int numberOfPatterns(int m, int n) {
        int res = 0;
        int[][] connections = new int[10][10];
        connections[1][7] = 4;
        connections[1][3] = 2;
        connections[1][9] = 5;
        connections[2][8] = 5;
        connections[3][1] = 2;
        connections[3][7] = 5;
        connections[3][9] = 6;
        connections[4][6] = 5;
        connections[6][4] = 5;
        connections[7][1] = 4;
        connections[7][3] = 5;
        connections[7][9] = 8;
        connections[8][2] = 5;
        connections[9][1] = 5;
        connections[9][3] = 6;
        connections[9][7] = 8;
        	for(int j = m; j<=n;j++) {
        		res += dfs(1, j, new boolean[10], connections) * 4;
        		res += dfs(2, j, new boolean[10], connections) * 4;
        		res += dfs(5, j, new boolean[10], connections);
        		
        	}
        
        return res;
    }
	
	private int dfs(int i, int number, boolean[] visited, int[][] connections) {
		if(number <= 0) return 0;
		if(number == 1) return 1;
		visited[i] = true;
		int res = 0;
		for(int j = 1; j <= 9; j++) {
			if(!visited[j] && (connections[i][j] == 0 || visited[connections[i][j]])) {
				res += dfs(j, number-1,visited, connections);
			}
		}
		visited[i] = false;
		return res;
	}
	
	
	// method 2
    public int numberOfPatterns2(int m, int n) {
        Integer res = 0;
        for(int i = m ; i <= n; i++) {
        	int[] a = new int[2];
        	boolean[][] bb = new boolean[3][3];
        	bb[0][0] = true;
        	helper(i, bb, 0, 0, a, 1);
        	
        	int[] b = new int[2];
        	bb = new boolean[3][3];
        	bb[0][1] = true;
        	helper(i, bb, 0, 1, b, 1);
        	
        	int[] c = new int[2];
            bb = new boolean[3][3];
        	bb[1][1] = true;
        	helper(i, bb, 1,1,c,1);
        	res += (a[0] * 4 + b[0] * 4 + c[0]);
        }
        return res;
    }

    private void helper(int n, boolean[][] set, int curI, int curJ, int[] res, int cur) {
    	if(cur == n) {
    		res[0]++;
    		
    		return;
    	}
    	
    	if( cur > n) return;
    	
    	for(int i = 0; i < 3 ; i++) {
    		for(int j = 0 ; j < 3; j++) {
    			if(set[i][j] || (i == curI && j == curJ)) continue;
    			if(curI == i && (curJ == j - 1 || curJ == j + 1)) {
    				set[i][j] = true;
    				helper(n, set, i, j, res, cur+1);
    				set[i][j] = false;
    			} else if (curJ == j && (i == curI-1 || i == curI + 1)) {
    				set[i][j] = true;
    				helper(n, set, i, j, res, cur+1);
    				set[i][j] = false;
    			} else if (curI == i && ((j == curJ + 2 && set[i][curJ+1] )||( j == curJ - 2 && set[i][curJ-1]) )) {
    			    set[i][j] = true;
    				helper(n, set, i, j, res, cur+1);
    				set[i][j] = false;
    			} else if(curJ == j && (( i == curI + 2 && set[curI+1][j])||(i == curI - 2) &&  set[curI-1][j] )) {
    			    set[i][j] = true;
    				helper(n, set, i, j, res, cur+1);
    				set[i][j] = false;
    			} else if((j == curJ + 1 && i == curI + 1) || (j == curJ - 1 && i == curI - 1) || (i == curI - 1 && j == curJ + 1) || (j == curJ - 1 && i == curI + 1)) {
    			    set[i][j] = true;
    				helper(n, set, i, j, res, cur+1);
    				set[i][j] = false;
    			} else if((j == curJ + 2 && i == curI + 2 && set[curI+1][curJ+1]) || (j == curJ - 2 && i == curI - 2 && set[curI-1][curJ-1]) || (i == curI - 2 && j == curJ + 2 && set[curI-1][curJ+1]) || (j == curJ - 2 && i == curI + 2 && set[curI+1][curJ-1])) {
    			    set[i][j] = true;
    				helper(n, set, i, j, res, cur+1);
    				set[i][j] = false;
    			} else if ((j == curJ + 2 && i == curI + 1) || (j == curJ - 2 && i == curI - 1) || (i == curI - 2 && j == curJ + 1) || (j == curJ - 2 && i == curI + 1)) {
    			    set[i][j] = true;
    				helper(n, set, i, j, res, cur+1);
    				set[i][j] = false;
    			} else if((j == curJ + 1 && i == curI + 2) || (j == curJ - 1 && i == curI - 2) || (i == curI - 1 && j == curJ + 2) || (j == curJ - 1 && i == curI + 2)) {
    			    set[i][j] = true;
    				helper(n, set, i, j, res, cur+1);
    				set[i][j] = false;
    			}
    		}
    	}
    }
}
