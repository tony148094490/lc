package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if(buildings.length == 0) return res;
        //populate points
        Point[] points = new Point[buildings.length * 2];
        Comparator<Point> comp = new Comparator<Point>(){
            @Override
            public int compare(Point a, Point b){
                if(a.x != b.x) {
                    return a.x - b.x;
                } else {
                    if(a.isLeft && b.isLeft) {
                        return b.y - a.y;
                    } else if(a.isLeft) {
                        return -1;
                    } else if(b.isLeft) {
                        return 1;
                    } else {
                        return a.y - b.y;
                    }
                }
            }
        };
        
        int i = 0;
        for(int[] p : buildings) {
            points[i] = new Point(p[0],p[2],true);
            i++;
            points[i] = new Point(p[1], p[2], false);
            i++;
        }
        
        Arrays.sort(points, comp);
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(0, 1);
        int prevH = 0;
        
        for(Point p : points) {
            if(p.isLeft) {
                map.compute(p.y, (key,value) -> {
                   if(value != null) {
                       return value + 1;
                   } 
                   return 1;
                });
            } else {
                map.compute(p.y, (key, value) -> {
                   if(value == 1) {
                       return null;
                   } 
                   return value - 1;
                });
            }
            
            int maxHeight = map.lastKey();
            if(maxHeight != prevH) {
                res.add(new int[]{p.x, maxHeight});
                prevH = maxHeight;
            }
        }
        return res;
    }
    
    private class Point {
        int x;
        int y;
        boolean isLeft;
        
        Point(int xx, int yy, boolean left) {
            x = xx;
            y = yy;
            isLeft = left;
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
