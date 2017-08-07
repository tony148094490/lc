package fb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KNearestPoints {
	public List<Point> getK(Point[] points, Point target, int k) {
		Comparator<Point> comp = (a, b) -> {return -getDistance(a, target) + getDistance(b, target);};
		PriorityQueue<Point> pq = new PriorityQueue<Point>(k, comp); // java pq doesnt have fixed size
		for(Point p : points) {
			if(pq.size() < k) {
				pq.add(p);
			} else {
				Point x = pq.peek();
				if(getDistance(x, target) > getDistance(p, target)) {
					pq.poll();
					pq.add(p);
				}
			}
		}

		List<Point> res = new ArrayList<>();
		res.addAll(pq);
		return res;
	}

	private int getDistance(Point a, Point b) {
		return (int) Math.pow(a.x-b.x, 2) + (int) Math.pow(a.y-b.y, 2);
	}
	
	
	
	public List<Point> get(Point[] points, Point point, int k) {
		for(Point p : points) {
			p.distance = (int) Math.pow(p.x - point.x, 2) + (int) Math.pow(p.y-point.y, 2);
		}
		partition(points, 0, points.length-1, k);
		List<Point> list = new ArrayList<>();
		for(int i = 0 ; i < k; i++) {
			list.add(points[i]);
		}
		return list;
	}
	
	private int partition(Point[] points, int left, int right, int k) {
		if(left == right) return left;
		int sorted = sort(points, left, right);
		if(sorted == k - 1) return sorted;
		if(sorted > k - 1) {
			return partition(points, left, sorted-1, k);
		} else {
			return partition(points, sorted+1, right, k);
		}
	}
	
	private int sort(Point[] points, int left, int right) {
		int pivot = left;
		int start = left + 1;
		int end = right;
		while(start <= end) {
			while(start <= end && points[start].distance <= points[pivot].distance) start++;
			while(start <= end && points[end].distance >= points[pivot].distance) end--;
			if(start < end) {
				Point temp = points[start];
				points[start] = points[end];
				points[end] = temp;
				start++;
				end--;
			} else {
				break;
			}
		}
		Point temp = points[end];
		points[end] = points[pivot];
		points[pivot] = temp;
		return end;
	}
	
	
	public static void main(String[] args) {
		KNearestPoints x = new KNearestPoints();
		Point a = x.new Point(1,1);
		Point b = x.new Point(2,2);
		Point c = x.new Point(3,3);
		Point d = x.new Point(4,5);
		Point e = x.new Point(3,4);
		Point f = x.new Point(4,3);
		Point g = x.new Point(5,2);
		
		Point[] points = {a,b,c,d,e,f,g};
		System.out.println(x.getK(points, c, 4));
		System.out.println(x.get(points, c, 4));
	}
	public class Point {
		int x;
		int y;
		int distance = 0;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return x + "," + y;
		}
	}
}
