package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Interval> res = new ArrayList<Interval>();
        if(intervals.size() == 0) return res;
        
        Comparator<Interval> comp = new Comparator<Interval>(){
        	@Override
        	public int compare(Interval a, Interval b) {
        		if(a.start < b.start) {
        			return -1;
        		} else if(a.start == b.start){
        			if(a.end < b.end){
        				return -1;
        			}  else if(a.end == b.end){
        				return 0;
        			}  else {
        				return 1;
        			}
        		} else {
        			return 1;
        		}
        	}
        };
        Interval[] arr = new Interval[intervals.size()];
        for(int i = 0 ; i < arr.length; i++){
        	arr[i] = intervals.get(i);
        }
        
        Arrays.sort(arr, comp);
        
        Interval prev = arr[0];
        res.add(prev);
        for(int i = 1; i < arr.length; i++) {
        	Interval cur = arr[i];
        	if(cur.start > prev.end){
        		res.add(cur);
        		prev = cur;
        	} else {
        		if(cur.end > prev.end) {
        			prev.end = cur.end;
        		} 
        	}
        }
        return res;
    }
}
