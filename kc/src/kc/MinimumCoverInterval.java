package kc;

import java.util.Arrays;
import java.util.Comparator;

/**
 */
public class MinimumCoverInterval {
	public int findCover(Interval[] intervals, Interval interval) {
		Comparator<Interval> comp = new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b) {
				if(a.start != b.start) return a.start - b.start;
				return a.end - b.end;
			}
		};
		Arrays.sort(intervals, comp);
		
		int start = interval.start;
		int index = 0;
		while( index < intervals.length && intervals[index].end < interval.start){
			index++;
		}
		int max = -1;
		int res = 0;
		while(index < intervals.length && max < interval.end) {
			if(intervals[index].start > start) break;
			while(index<intervals.length&&intervals[index].start <= start) {
				max = Math.max(max, intervals[index].end);
				index++;
			}
			if(start != max) {
				res++;
				start = max;
			}
		}
		if(max < interval.end) return 0;
		return res;
	}
}

