package kc;

import java.util.ArrayList;
import java.util.List;

public class VectorDotProduct {
	public int dotProduct(int[] A, int[] B) {
		List<Point> a = new ArrayList<>();
		List<Point> b = new ArrayList<>();
		for(int i = 0 ; i < A.length; i++) {
			if(A[i] != 0)
			a.add(new Point(i, A[i]));
		}
		
		for(int i = 0 ; i < B.length; i++) {
			if(B[i] != 0)
			b.add(new Point(i, B[i]));
		}
		
		int res = 0;
		for(int i = 0 ; i < b.size(); i++) {
			Point cur = b.get(i);
			Point cor = bs(a, cur.i);
			if(cor != null) res += cur.v * cor.v;
		}
		return res;
	}
	
	private Point bs(List<Point> A, int index) {
		int lo = 0;
		int hi = A.size()-1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			Point p = A.get(mid);
			if(p.i == index) {
				return p;
			} else if(p.i < index) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		
		return null;
		
	}
	
	
	
	public class Point {
		int i;
		int v;
		public Point(int i, int v) {
			this.i = i;
			this.v = v;
		}
	}
}
