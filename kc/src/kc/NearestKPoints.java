package kc;

public class NearestKPoints {
	public Point getNearest(Point[] points, int k) {
		return quickselect(points, 0, points.length-1, k);
	}
	
	private Point quickselect(Point[] points, int left, int right, int k) {
		if(left == right) {
			return points[left];
		}
		
		int sorted = partition(points, left, right);
		if(sorted == k-1) {
			return points[sorted];
		} else if(sorted > k - 1) {
			return quickselect(points, left, sorted-1,k);
		} else {
			return quickselect(points,sorted+1,right, k);
		}
	}
	
	private int partition(Point[] points, int start, int end) {
		int pivot = start;
		int left = start+1;
		int right = end;
		while(left <= right) {
			while(left<=right && closerOrEqual(points[left], points[pivot])) left++;
			while(left<=right && closerOrEqual(points[pivot], points[right])) right--;
			if(left<=right) {
				swap(points, left, right);
				left++;
				right--;
			} else {
				break;
			}
		}
		swap(points, pivot, right);
		return right;
	}
	
	private boolean closerOrEqual(Point a, Point b) {
		return a.x * a.x + a.y*a.y - b.x * b.x - b.y*b.y <= 0;
	}
	
	private void swap(Point[] points, int i, int j) {
		int tempX = points[i].x;
		int tempY = points[i].y;
		points[i].x = points[j].x;
		points[i].y = points[j].y;
		points[j].x = tempX;
		points[j].y = tempY;
	}
}
