package kc;

import java.util.ArrayList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. 
 * We may perform an addLand operation which turns the water at position (row, col) into a land. 
 * Given a list of positions to operate, count the number of islands after each addLand operation. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0

Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0

Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0

Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0

Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0

We return the result as an array: [1, 1, 2, 3]

Challenge:
Can you do it in time complexity O(k log mn), where k is the length of the positions?
 *
 */
public class NumberOfIslandsII {
    int counter;
    int[][] map;
    int[][] sizes;
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        map = new int[m][n];
        
        for(int i = 0 ; i < map.length; i++) {
            for(int j = 0 ; j < map[0].length; j++) {
                map[i][j] = -1;
            }
        }
        
        sizes = new int[m][n];
        counter = 0;
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0 ; i < positions.length; i++) {
            int r = positions[i][0];
            int c = positions[i][1];
            sizes[r][c] = 1;
            int hashed = n * r + c;
            map[r][c] = hashed;
            counter++;
            
            if(r > 0 && map[r-1][c] != -1) {
                union(r-1, c, r, c);
            }
            
            if(r < map.length-1 && map[r+1][c] != -1) {
                union(r+1, c, r, c);
            }
            if(c > 0 && map[r][c-1] != -1) {
                union(r,c-1, r, c);
            }
            if(c < map[0].length-1 && map[r][c+1] != -1) {
                union(r,c+1, r, c);
            }
            
            res.add(counter);
        }
        return res;
    }
    
    private void union(int firstRow, int firstCol, int secondRow, int secondCol) {
        int firstParent = find(firstRow, firstCol);
        int secondParent = find(secondRow, secondCol);
        if(firstParent == secondParent) return;
        int firstParentRow = firstParent/map[0].length;
        int firstParentCol = firstParent - firstParentRow * map[0].length;
        int secondParentRow = secondParent/map[0].length;
        int secondParentCol = secondParent - secondParentRow * map[0].length;
        if(sizes[firstParentRow][firstParentCol] < sizes[secondParentRow][secondParentCol]) {
            map[firstParentRow][firstParentCol] = secondParent;
            sizes[secondParentRow][secondParentCol] += sizes[firstParentRow][firstParentCol];
        } else {
            map[secondParentRow][secondParentCol] = firstParent;
            sizes[firstParentRow][firstParentCol] += sizes[secondParentRow][secondParentCol];
        }
        counter--;
    }
    
    private int find(int r, int c) {
        while(map[r][c] != map[r].length * r + c) {
            int row = map[r][c] / map[r].length;
            int col = map[r][c] - row * map[r].length;
            r = row;
            c = col;
        }
        return r * map[r].length + c;
    }
}
