package kc;

import java.util.Arrays;
import java.util.LinkedList;

public class Bipartite {

	final static int V = 4;
	public boolean isBipartite(int[][] G, int src) {
		int[] colorCode = new int[V];
		Arrays.fill(colorCode, -1);
		colorCode[src] = 1;
		LinkedList<Integer> q = new LinkedList<>();
		q.add(src);
		while(!q.isEmpty()) {
			int parent = q.poll();
			for(int i = 0 ; i < V; i++) {
				if(G[parent][i] == 1 && colorCode[i] == -1) {
					colorCode[i] = 1 - colorCode[parent];
					q.add(i);
				} else if (G[parent][i] == 1 && colorCode[i] == colorCode[parent] ){
					return false;
				}
			}
		}
		return true;
	}
}
