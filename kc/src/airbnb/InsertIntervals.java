package airbnb;

import java.util.ArrayList;
import java.util.List;

import kc.Interval;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
 */
public class InsertIntervals {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int initialSize = intervals.size();
        for(int i = 0; i < intervals.size(); i++) {
        	Interval cur = intervals.get(i);
        	if(cur.start == newInterval.start){
        		if(newInterval.end < cur.end){
        			intervals.add(i, newInterval);
        			break;
        		} else {
        			intervals.add(i+1, newInterval);
        			break;
        		}
        	} else if(cur.start > newInterval.start){
        		intervals.add(i, newInterval);
        		break;
        	} 
        }
        if(initialSize == intervals.size()) {
        	intervals.add(newInterval);
        }
        
        List<Interval> list = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        list.add(prev);
        for(int i = 1; i < intervals.size();i++) {
        	Interval cur = intervals.get(i);
        	if(cur.start > prev.end) {
        		list.add(cur);
        		prev = cur;
        	} else {
        		if(prev.end < cur.end) {
        			prev.end = cur.end;
        		} 
        	}
        }
        return list;
    }
}
