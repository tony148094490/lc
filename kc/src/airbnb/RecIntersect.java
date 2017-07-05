package airbnb;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// https://tinyurl.com/y7xl5dls
//  You have a plain with lots of rectangles on it, find out how many of them intersect.
// http://www.1point3acres.com/bbs/thread-220456-1-1.html
// looks like the sides of given rectangles are paralle with x and y axis
// inspired by two ansewrs from web
// one is line sweeping, another is union-find
// the key question to ask is :if three recs intersecting each other, 1)how many intersections 2) intersected recs are there?
// answer to the above question 1) 2 or 3 , 2) 3
// below are two ways to answering the above question
// also even if edges are overlapped, they should still count as intersected
// my guess would be to generate number of intersections , couting overlapped intersections separately or not.

public class RecIntersect {

	// well, double comparison should not be done like this but ...
	// below impl is counting overlapped intercestions separately
	// there is anohter impl based on " if A intersects B and A intersects C and B intersects C, then one of the overlaps is overlapped..
	// time is N*lgN + N * (lgN? otherwise it's no use) where N is 2 * number of recs, worst case could be N^2 though
	public int getIntersectedRec(Rectangle[] recs) {
		TreeSet<Line> sortedX = new TreeSet<>();
		for(Rectangle x : recs) {
			sortedX.add(x.leftMost);
			sortedX.add(x.rightMost);
		}
		
		TreeSet<Line> sortedY = new TreeSet<>();
		int res = 0;
		for(Line xLine : sortedX) {
			Rectangle r = xLine.rect;
			if(xLine.isStart) {
				res += getIntersection(sortedY, r.upMost, r.downMost);
				sortedY.add(r.upMost);
				sortedY.add(r.downMost);
			} else {
				sortedY.remove(r.upMost);
				sortedY.remove(r.downMost);
			}
		}
		
		return res;
	}
	
	// not sure how much this costs but might be O(1)
	private int getIntersection(TreeSet<Line> sortedY, Line up, Line down) {
		Set<Rectangle> recSet = new HashSet<>();
		TreeSet<Line> subset = (TreeSet<Line>) sortedY.subSet(down, true, up, true);
		for(Line l : subset) {
			recSet.add(l.rect);
		}
		return recSet.size();
	}
	
	public static void main(String[] args) {
		RecIntersect sol = new RecIntersect();
		Rectangle [] rects = {
                sol.new Rectangle(1, 1, 3, 3),
                sol.new Rectangle(2, 5, 4, 6),
                sol.new Rectangle(2.5,2,3.5,5.5)
        };
		
		System.out.println(sol.getIntersectedRec(rects));
		System.out.println(sol.get(rects));
	}
	
	public class Rectangle {
		Line leftMost;
		Line rightMost;
		Line upMost;
		Line downMost;
		public Rectangle(double minX, double minY, double maxX, double maxY) {
			leftMost = new Line(minX, true, this);
			rightMost = new Line(maxX, false, this);
			upMost = new Line(maxY, true, this);
			downMost = new Line(minY, false, this);
		}
	}
	
	public class Line implements Comparable<Line>{
		double v;
		boolean isStart;
		Rectangle rect;
		public Line(double v, boolean isStart, Rectangle rec) {
			this.v = v;
			this.isStart = isStart;
			this.rect = rec;
		}
		
		public int compareTo(Line other) {
			if(this.v != other.v) {
				if(this.v > other.v ){
					return 1;
				} 
				return -1;
			}
			
			if(this.isStart && !other.isStart) {
				return -1;
			}else if (!this.isStart && other.isStart) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	
	// second impl which doesnt add a new intersection if the new rec is intersected two intersected regions
	// time is n^2, this is easier to understand
	public int get(Rectangle[] rects) {
		int[] roots = new int[rects.length];
		for(int i = 0 ; i < rects.length; i++) roots[i] = i;
		
		int res = 0;
		for(int i = 0 ; i < rects.length; i++) {
			for(int j = i+1; j < rects.length; j++) {
				if(isIntersected(rects[i], rects[j])
						|| isIntersected(rects[j], rects[i])) {
					int iRoot = findRoot(i, roots);
					int jRoot = findRoot(j, roots);
					if(iRoot != jRoot) {
						res += 1;
						roots[iRoot] = jRoot;
					}
				}
			}
		}
		return res;
	}
	
	private boolean isIntersected(Rectangle r1, Rectangle r2) {
		if(r1.leftMost.v >= r2.leftMost.v && r1.leftMost.v <= r2.rightMost.v &&
				r1.downMost.v >= r2.downMost.v && r1.downMost.v <= r2.upMost.v) return true;

		if(r1.rightMost.v >= r2.leftMost.v && r1.rightMost.v <= r2.rightMost.v &&
				r1.downMost.v >= r2.downMost.v && r1.downMost.v <= r2.upMost.v) return true;

		if(r1.rightMost.v >= r2.leftMost.v && r1.rightMost.v <= r2.rightMost.v &&
				r1.upMost.v >= r2.downMost.v && r1.upMost.v <= r2.upMost.v) return true;

		if(r1.leftMost.v >= r2.leftMost.v && r1.leftMost.v <= r2.rightMost.v &&
				r1.upMost.v >= r2.downMost.v && r1.upMost.v <= r2.upMost.v) return true;
		return false;
	}
	
	private int findRoot(int r, int[] roots) {
		int parent = roots[r];
		if(parent != r) {
			roots[r] = findRoot(parent, roots);
		}
		return roots[r];
	}
}
