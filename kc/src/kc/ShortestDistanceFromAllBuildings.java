package kc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches 
 * all buildings in the shortest amount of distance. 
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

    Each 0 marks an empty land which you can pass by freely.
    Each 1 marks a building which you cannot pass through.
    Each 2 marks an obstacle which you cannot pass through.

For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

The point (1,2) is an ideal empty land to build a house, 
as the total travel distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building. 
If it is not possible to build such house according to the above rules, return -1.
 */
public class ShortestDistanceFromAllBuildings {

	int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestDistance(int[][] grid) {
    	if(grid.length == 0 || grid[0].length == 0) return 0;
    	List<Point> ps = new ArrayList<>();
    	int[][] dist = new int[grid.length][grid[0].length];
    	for(int i = 0 ; i < grid.length; i++) {
    		for(int j = 0 ; j < grid[0].length ;j++) {
    			if(grid[i][j] == 1) {
    				Point p = new Point(i, j , 0);
    				ps.add(p);
    			}
    			grid[i][j] = -1 * grid[i][j];
    		}
    	}

    	int counter = 0;
    	for(Point p : ps) {

    		bfs(grid, dist, p, counter);
    		counter++;

    	}
    	int res = -1;
    	for(int i = 0 ; i < grid.length; i++) {
    		for(int j = 0 ; j < grid[0].length ;j++) {
    			if(grid[i][j] != counter) continue;
    			if(res == -1) {
    				res = dist[i][j];
    			} else {
    				res = Math.min(res, dist[i][j]);
    			}
    		}
    	}
    	
    	return res;
    }
    
    private void bfs(int[][] grid, int[][] dist, Point root, int i) {
    	Queue<Point> points = new LinkedList<Point>();
    	points.add(root);
    	while(!points.isEmpty()) {
    		Point p = points.poll();
    		dist[p.x][p.y] += p.d;
    		for(int[] di : dir) {
    			int x = p.x + di[0];
    			int y = p.y + di[1];
    			if(x >= 0 && x < grid.length && y>=0 && y<grid[0].length && grid[x][y] == i) {
    				points.add(new Point(x, y, p.d + 1));
    				grid[x][y] = i + 1;
    			}
    		}
    	}
    }
    
    public class Point {
    	int x;
    	int y;
    	int d;
    	public Point(int x, int y, int d) {
    		this.x = x;
    		this.y = y;
    		this.d = d;
    	}
    	
    }
    
    
    public static void main(String[] args) {
		int[][] arr = new int[3][5];
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[0][2] = 2;
		arr[0][3] = 0;
		arr[0][4] = 1;
		
		arr[2][0] = 0;
		arr[2][1] = 0;
		arr[2][2] = 1;
		arr[2][3] = 0;
		arr[2][4] = 0;
		
		ShortestDistanceFromAllBuildings x = new ShortestDistanceFromAllBuildings();
		System.out.println(x.shortestDistance(arr));
	}
    
    private void printMap(int[][] arr) {
    	for(int i = 0 ; i < arr.length ;i++) {
    		for(int j = 0 ; j < arr[0].length ;j++) {
    			System.out.print(arr[i][j] + ",");
    		}
    		System.out.println();
    	}
    }
}
