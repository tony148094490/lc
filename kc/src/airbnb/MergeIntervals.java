package airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kc.Interval;

/**
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty()) return new ArrayList<>();
        Comparator<Interval> comp = (a,b) -> {return a.start - b.start;};
        
        Collections.sort(intervals, comp);
        
        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        Interval last = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if(cur.start > last.end) {
                res.add(cur);
                last = cur;
            } else {
                last.end = Math.max(cur.end, last.end);
            }
        }
        return res;
    }
}
