package fb;

import java.util.Arrays;
import java.util.Comparator;

import kc.Interval;

/**
 * 
Find least number of intervals from A that can fully cover B
For example:
Given A=[[0,3],[3,4],[4,6],[2,7]] B=[0,6] return 2 since we can use [0,3] [2,7] to cover the B
Given A=[[0,3],[4,7]] B=[0,6] return 0 since we cannot find any interval combination from A to cover the B
 */
public class MinCoverFromAtoB {
	public int findCover(Interval[] intervals, Interval cover) {
		Comparator<Interval> comp = new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2) {
				if(i1.start != i2.start) return i1.start - i2.start;
				return i1.end - i2.end;
			}
		};
		
		Arrays.sort(intervals, comp);
		
		int index = 0;
		int curStart = cover.start;
		int curEnd = -1;
		int count = 0;
		while(index < intervals.length && curEnd < cover.end) {
			if(intervals[index].end < curStart) {
				index++;
				continue;
			}
			
			if(intervals[index].start > curStart) {
				break;
			}
			
			while(index < intervals.length && curEnd < cover.end && intervals[index].start <= curStart) {
				curEnd = Math.max(curEnd, intervals[index].end);
				index++;
			}
			
			if(curStart != curEnd || curStart == cover.start) {
				count++;
				curStart = curEnd;
			}
		}
		
		if(curEnd < cover.end) return 0;
		return count;
	}
	
	public static void main(String[] args) {
		Interval[] intervals = new Interval[4];
		intervals[0] = new Interval(0, 3);
		intervals[1] = new Interval(4, 6);
		intervals[2] = new Interval(5, 7);
		intervals[3] = new Interval(9, 10);
		
		Interval cover = new Interval(3,3);
		
		MinCoverFromAtoB minCover = new MinCoverFromAtoB();
		System.out.println(minCover.findCover(intervals, cover));
		
	}
}
