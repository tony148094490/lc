package airbnb;

import java.util.Arrays;
import java.util.Comparator;

import kc.Interval;

public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        Point[] points = new Point[intervals.length * 2];
        int i = 0;
        for(Interval interval : intervals) {
            Point start = new Point(interval.start);
            start.isStart = true;
            Point end = new Point(interval.end);
            points[i] = start;
            i++;
            points[i] = end;
            i++;
        }
        
        int res = 0;
		Comparator<Point> comp = new Comparator<Point>(){
            @Override
            public int compare(Point a, Point b) {
                if(a.time != b.time) return a.time-b.time;
                if(a.isStart) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        
        Arrays.sort(points, comp);
        
        int max = 0;
        for(Point p : points) {
            if(p.isStart) {
                res++;
                max = Math.max(max, res);
            } else {
                res--;
            }
        }
        return max;
    }
    
    public class Point {
     	int time;
        boolean isStart;
		public Point(int v) {
            time = v;
        }
    }
}
