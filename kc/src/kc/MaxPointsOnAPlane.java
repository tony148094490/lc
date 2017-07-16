package kc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnAPlane {
    public int maxPoints(Point[] points) {
        if(points.length <= 2) return points.length;
        int res = 2;
        for(int i = 0 ; i < points.length; i++) {
            Map<BigDecimal, Integer> map = new HashMap<>();
            int samePoints = 0;
            Map<Integer, Integer> xs = new HashMap<>();
            Point cur = points[i];
            for(int j = 0 ; j < points.length; j++) {
                if(i == j) continue;
                Point next = points[j];
                if(cur.x == next.x && cur.y == next.y) {
                    samePoints++;
                }
                
                if (cur.x == next.x) {
                    xs.putIfAbsent(cur.x, 1);
                    xs.put(cur.x, xs.get(cur.x) + 1);
                    res = Math.max(res, xs.get(cur.x));
                } else {
                    BigDecimal slope = new BigDecimal(cur.y - next.y).divide(new BigDecimal(cur.x-next.x), MathContext.DECIMAL128);
                    if(map.containsKey(slope)) {
                        map.put(slope, map.get(slope) + 1);
                        res = Math.max(res, map.get(slope) + samePoints);
                    } else {
                        map.put(slope, 2);
                    }
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
		Point a = new Point();
		Point b = new Point();
		Point c = new Point();
		Point d = new Point();
		
		a.x = 0; a.y = 0;
		b.x = 94911151; b.y = 94911150;
		
		c.x = 94911152; c.y = 94911151;

		Point[] p = new Point[3];
		p[0] = a;
		p[1] = b;
		p[2] = c;
		//p[3] = d;
		
		MaxPointsOnAPlane x = new MaxPointsOnAPlane();
		System.out.println(x.maxPoints(p));
	}
}
