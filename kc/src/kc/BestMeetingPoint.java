package kc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
    	List<Integer> xs = new ArrayList<Integer>();
    	List<Integer> ys = new ArrayList<Integer>();
    	
        for(int i = 0 ; i < grid.length; i++) {
        	for(int j = 0 ; j < grid[0].length; j++) {
        		if(grid[i][j] == 1) {
        			xs.add(i);
        			ys.add(j);
        		}
        	}
        }
        return getDistance(xs) + getDistance(ys);
    }
    
    private int getDistance(List<Integer> indexes) {
    	int res = 0;
    	Collections.sort(indexes);
    	int i = 0 ; 
    	int j = indexes.size() - 1;
    	while(i < j) {
    		res += (indexes.get(j) - indexes.get(i));
    		i++;j--;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		int[][] arr = new int[3][5];
		arr[0][0]= 1;
		arr[0][1]= 0;
		arr[0][2]= 0;
		arr[0][3]= 0;
		arr[0][4]= 1;
		
		arr[1][0]= 0;
		arr[1][1]= 0;
		arr[1][2]= 0;
		arr[1][3]= 0;
		arr[1][4]= 0;
		
		arr[2][0]= 0;
		arr[2][1]= 0;
		arr[2][2]= 1;
		arr[2][3]= 0;
		arr[2][4]= 0;
		BestMeetingPoint x = new BestMeetingPoint();
		System.out.println(x.minTotalDistance(arr));
	}
}
