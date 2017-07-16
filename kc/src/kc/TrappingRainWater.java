package kc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        int cur = 0;
        if(height.length == 0) return 0;
        int left = height[0];
        for(int i = 1; i < height.length; i++) {
        	if(height[i] >= left) {
        		left = height[i];
        		res += cur;
        		cur = 0;
        	} else {
        		cur += (left - height[i]);
        	}
        }
        
        cur = 0;
        left = height[height.length-1];
        for(int i = height.length - 1; i >= 0; i--) {
        	if(height[i] > left) {
        		left = height[i];
        		res += cur;
        		cur = 0;
        	} else {
        		cur += (left - height[i]);
        	}
        }
        
        return res;
    }
    
    
    public int trapRainWater2(int[][] heightMap) {
        if(heightMap.length == 0) return 0;
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        Comparator<int[]> comp = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return heightMap[a[0]][a[1]] - heightMap[b[0]][b[1]];
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);
        for(int i = 0 ; i < heightMap.length; i++) {
            // left
            pq.add(new int[]{i, 0});
            visited[i][0] = true;
            
            // right
            if(heightMap[0].length > 1) {
                pq.add(new int[]{i, heightMap[i].length-1});
                visited[i][heightMap[i].length-1] = true;
            }
        }
        
        for(int j = 0 ; j < heightMap[0].length; j++) {
            // get top
            pq.add(new int[]{0, j});
            visited[0][j] = true;
            
            // get bottom
            if(heightMap.length > 1) {
                pq.add(new int[]{heightMap.length-1,j});
                visited[heightMap.length-1][j] = true;
            }
        }
        
        int res = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()) {
            int[] lowest = pq.poll();
            int i = lowest[0];
            int j = lowest[1];
            int height = heightMap[i][j];
            for(int[] dir : dirs) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if(ii < 0 || ii >= heightMap.length || jj < 0 || jj >= heightMap[0].length) continue;
                if(visited[ii][jj]) continue;
                visited[ii][jj] = true;
                int h = heightMap[ii][jj];
                if(h < height) {
                    res += height - h;
                    heightMap[ii][jj] = height;
                }
                pq.add(new int[]{ii, jj});
            }
        }
        
        return res;
    }
    
    
    public static void main(String[] args) {
    	TrappingRainWater x = new TrappingRainWater();
    	int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println(x.trap(arr));
    	int[] arr2 = {2,0,2};
    	System.out.println(x.trap(arr2));
    	
    	
	}
}
