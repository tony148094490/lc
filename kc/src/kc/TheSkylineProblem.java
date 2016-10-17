package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
    	List<int[]> res = new ArrayList<int[]>();
    	Point[] points = new Point[buildings.length * 2];
    	int counter = 0;
    	for(int i = 0 ; i < buildings.length; i++) {
    		points[counter] = new Point();
    		points[counter].x = buildings[i][0];
    		points[counter].y = buildings[i][2];
    		points[counter].start = true;
    		counter++;
    		
    		points[counter] = new Point();
    		points[counter].x = buildings[i][1];
    		points[counter].y = buildings[i][2];
    		points[counter].start = false;
    		counter++;
    	}
    	Arrays.sort(points);
    	for(Point p : points) {
    	    System.out.println("(" + p.x +"," + p.y +")");
    	}
    	TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
    	treeMap.put(0, 1);
    	int prevMaxHeight = 0;
    	for (Point p : points) {
    		if(p.start) {
    			treeMap.compute(p.y, (key, value) -> {
    				if(value != null) {
    					return value + 1;
    				} 
    				return 1;
    			});
    		} else {
    			treeMap.compute(p.y, (key, value) -> {
    				if(value == 1) {
    					return null;
    				}
    				return value - 1;
    			});
    		}
    		
    		int curMax = treeMap.lastKey();
    		
    		if(curMax != prevMaxHeight) {
    			res.add(new int[]{p.x, curMax});
    			prevMaxHeight = curMax;
    		}
    	}
    	
    	return res;
    	
    }
    
    private class Point implements Comparable<Point>{
    	int x;
    	int y;
    	boolean start;
    	
    	@Override
    	public int compareTo(Point b) {
    		if(this.x != b.x) {
    			return this.x - b.x;
    		} else {
    			if(this.y > b.y){
    				if(this.start && b.start) {
    					return -1;
    				} else if(this.start) {
    					return -1;
    				} else if(b.start){
    					return 1;
    				} else {
    					return 1;
    				}
    			}  else if(this.y < b.y){
    				if(this.start && b.start) {
    					return 1;
    				} else if(this.start) {
    					return -1;
    				} else if(b.start){
    					return 1;
    				} else {
    					return -1;
    				}
    			}  else {
    				if(this.start) {
    				    return -1;
    				} else {
    				    return 1;
    				}
    			}
    		} 
    	}
    }
    
    public static void main(String[] args) {
    	//[[0,5,7],[5,10,7],[5,10,12],[10,15,7],[15,20,7],[15,20,12],[20,25,7]]
    	int[][] buildings = new int[7][3];
    	buildings[0][0] = 0;
    	buildings[0][1] = 5;
    	buildings[0][2] = 7;
    	
    	buildings[1][0] = 5;
    	buildings[1][1] = 10;
    	buildings[1][2] = 7;
    	
    	buildings[2][0] = 5;
    	buildings[2][1] = 10;
    	buildings[2][2] = 12;
    	
    	buildings[3][0] = 10;
    	buildings[3][1] = 15;
    	buildings[3][2] = 7;
    	
    	buildings[4][0] = 15;
    	buildings[4][1] = 20;
    	buildings[4][2] = 7;
    	
    	buildings[5][0] = 15;
    	buildings[5][1] = 20;
    	buildings[5][2] = 12;
    	
    	buildings[6][0] = 20;
    	buildings[6][1] = 25;
    	buildings[6][2] = 7;
    	
    	TheSkylineProblem x = new TheSkylineProblem();
    	List<int[]> res = x.getSkyline(buildings);
    	for(int[] arr : res) {
    		System.out.println(arr[0] + "," + arr[1]);
    		
    	}
    }
}
