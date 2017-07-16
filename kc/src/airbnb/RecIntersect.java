package airbnb;

import java.util.Comparator;
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

//  #2 You have a plain with lots of rectangles on it, find out how many of them intersect.
public class RecIntersect {

	// well, double comparison should not be done like this but ...
	// below impl is counting overlapped intercestions separately
	// there is anohter impl based on " if A intersects B and A intersects C and B intersects C, then one of the overlaps is overlapped..
	// time is N*lgN + N * (lgN? otherwise it's no use) where N is 2 * number of recs, worst case could be N^2 though
	public int getInter(Rec[] recs) {
		Comparator<Line> comp = new Comparator<Line>(){
			@Override
			public int compare(Line a, Line b) {
				if(a.value != b.value) {
					if(a.value > b.value) return 1;
					if(a.value < b.value) return -1;
					return 0;
				}
				if(a.lower && !b.lower) {
					return -1;
				} else if(!a.lower && b.lower) {
					return 1;
				} else {
					return 0;
				}
			}
		};

		TreeSet<Line> xss = new TreeSet<Line>(comp);
		for(Rec rec : recs) {
			xss.add(new Line(rec.xmin, true, rec));
			xss.add(new Line(rec.xmax, false, rec));
		}


		Comparator<Rec> intervalComp = new Comparator<Rec>(){
			@Override
			public int compare(Rec a, Rec b) {
				if(a.ymin != b.ymin) return a.ymin - b.ymin < 0 ? -1 : 1;
				return a.ymax - b.ymax < 0 ? -1 : 1;
			}
		};

		TreeSet<Rec> yinterval = new TreeSet<>(intervalComp);

		Set<Rec> res = new HashSet<>();
		for(Line line : xss) {
			if(line.lower) {
				Rec r = line.rec;
				Rec floor = yinterval.floor(r);
				Rec ceiling = yinterval.ceiling(r);

				if(floor != null && ((floor.ymin <= r.ymin && floor.ymax >= r.ymin) || (floor.ymin <= r.ymax && floor.ymax >= r.ymax))) {
					res.add(r);
				} else if(ceiling != null && ((ceiling.ymin <= r.ymin && ceiling.ymax >= r.ymin) || (ceiling.ymin <= r.ymax && ceiling.ymax >= r.ymax))) {
					res.add(r);
				}
				res.add(r);
				yinterval.add(r);
			} else {
				yinterval.remove(line.rec);
			}
		}

		return res.size();
	}

	public class Line {
		double value;
		boolean lower;
		Rec rec;
		public Line(double v, boolean l, Rec r) {
			value = v;
			lower = l;
			rec = r;
		}
	}

	public class Rec {
		double xmin;
		double xmax;
		double ymin;
		double ymax;
		public Rec(double xmin, double xmax, double ymin, double ymax) {
			this.xmin = xmin;
			this.xmax = xmax;
			this.ymin = ymin;
			this.ymax = ymax;
		}
	}
	
	public static void main(String[] args) {
		RecIntersect sol = new RecIntersect();
		Rec [] rects = {
                sol.new Rec(0, 0, 4, 4),
                sol.new Rec(1, 1, 5, 3),
                sol.new Rec(4.5,0,4.8,2.5)
        };
		
		Rec [] rects2 = {
                sol.new Rec(0, 1, 4, 2),
                sol.new Rec(0, 4, 4, 5),
                sol.new Rec(1,2,0,5)
        };
		
		System.out.println(sol.getInter(rects));
		System.out.println(sol.getInter(rects2));

	}
	
	
	// second impl which doesnt add a new intersection if the new rec is intersected two intersected regions
	// time is n^2, this is easier to understand
//	public int get(Rectangle[] rects) {
//		int[] roots = new int[rects.length];
//		for(int i = 0 ; i < rects.length; i++) roots[i] = i;
//		
//		int res = 0;
//		for(int i = 0 ; i < rects.length; i++) {
//			for(int j = i+1; j < rects.length; j++) {
//				if(isIntersected(rects[i], rects[j])
//						|| isIntersected(rects[j], rects[i])) {
//					int iRoot = findRoot(i, roots);
//					int jRoot = findRoot(j, roots);
//					if(iRoot != jRoot) {
//						res += 1;
//						roots[iRoot] = jRoot;
//					}
//				}
//			}
//		}
//		return res;
//	}
//	
//	private boolean isIntersected(Rec r1, Rectangle r2) {
//		if(r1.leftMost.v >= r2.leftMost.v && r1.leftMost.v <= r2.rightMost.v &&
//				r1.downMost.v >= r2.downMost.v && r1.downMost.v <= r2.upMost.v) return true;
//
//		if(r1.rightMost.v >= r2.leftMost.v && r1.rightMost.v <= r2.rightMost.v &&
//				r1.downMost.v >= r2.downMost.v && r1.downMost.v <= r2.upMost.v) return true;
//
//		if(r1.rightMost.v >= r2.leftMost.v && r1.rightMost.v <= r2.rightMost.v &&
//				r1.upMost.v >= r2.downMost.v && r1.upMost.v <= r2.upMost.v) return true;
//
//		if(r1.leftMost.v >= r2.leftMost.v && r1.leftMost.v <= r2.rightMost.v &&
//				r1.upMost.v >= r2.downMost.v && r1.upMost.v <= r2.upMost.v) return true;
//		return false;
//	}
//	
//	private int findRoot(int r, int[] roots) {
//		int parent = roots[r];
//		if(parent != r) {
//			roots[r] = findRoot(parent, roots);
//		}
//		return roots[r];
//	}
}
