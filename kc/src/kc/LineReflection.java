package kc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LineReflection {
    public boolean isReflected(int[][] points) {
        double xmin = Integer.MAX_VALUE;
        double xmax = Integer.MIN_VALUE;
        Map<Double, Set<Double>> map = new HashMap<Double, Set<Double>>();
        for(int[] point : points) {
        	double x = point[0];
        	double y = point[1];
            xmin = Math.min(xmin, x);
            xmax = Math.max(xmax, x);
            if(map.containsKey(x)) {
                map.get(x).add(y);
            } else {
                Set<Double> set = new HashSet<Double>();
                set.add(y);
                map.put(x, set);
            }
        }
        
        double xmid = (xmax + xmin) / 2;

        for(int[] point : points) {
            double y = point[1];
            double reflectedX = 2 * xmid - point[0];
            if(!map.containsKey(reflectedX) || !map.get(reflectedX).contains(y)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
		System.out.println(1.0/2);
	}
}
