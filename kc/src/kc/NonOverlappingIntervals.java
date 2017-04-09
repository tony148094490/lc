package kc;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        Comparator<Interval> comp = new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                if(a.start != b.start) return a.start - b.start;
                return a.end - b.end;
            }
        };
        
        Arrays.sort(intervals, comp);
        
        int res = 0;
        int max = intervals[0].end;
        for(int i = 1 ; i < intervals.length; i++) {
            if(intervals[i].start < max) {
                res++;
                max = Math.min(max, intervals[i].end);
            } else {
                max = intervals[i].end;
            } 
        }
        return res;
    }
}
