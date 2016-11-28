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
}
