package kc;

import java.util.ArrayList;
import java.util.List;

public class DataStreamAsDisjointIntervals {
	public static class SummaryRanges {
		List<Interval> ranges;
		
	    /** Initialize your data structure here. */
	    public SummaryRanges() {
	    	ranges = new ArrayList<Interval>();
	    }
	    
	    public void addNum(int val) {
	        int position = getInsertionPoint(val);
	        if(position < ranges.size()) {
	        	Interval interval = ranges.get(position);
	        	if(interval.start <= val && val <= interval.end) return;
        		Interval newInterval = new Interval(val, val);
	        	
        		if(interval.start > val) {
	        		if(val == interval.start - 1 && position - 1 >= 0 && ranges.get(position-1).end + 1 == val) {
	        			interval.start = ranges.get(position-1).start;
	        			ranges.remove(position-1);
	        		} else if(val == interval.start - 1) {
	        			interval.start = val;
	        		} else if(position - 1 >= 0 && ranges.get(position-1).end + 1 == val) {
        				ranges.get(position-1).end = val;
        			} else if (interval.start > val) {
    	        		ranges.add(position, newInterval);
        			}	
	        	} else {
	        		if(val == interval.end + 1 && position + 1 < ranges.size() && ranges.get(position+1).start - 1 == val) {
	        			interval.end = ranges.get(position+1).end;
	        			ranges.remove(position+1);
	        		} else if(val == interval.end + 1) {
	        			interval.end = val;
	        		} else if(position + 1 < ranges.size() && ranges.get(position+1).start - 1 == val) {
	        			ranges.get(position+1).start = val;
	        		} else {
	        			ranges.add(position + 1, newInterval);
	        		}
	        	}
        		
        		
	        } else {
	        	if(ranges.size() > 0 && ranges.get(ranges.size()-1).end + 1 == val) {
	        		ranges.get(ranges.size()-1).end = val;
	        		return;
	        	}
	        	Interval interval = new Interval(val, val);
	        	ranges.add(interval);
	        }
	    }
	    
	    public List<Interval> getIntervals() {
	    	return ranges;
	    }
	    
	    private int getInsertionPoint(int val) {
	    	
	    	int right = ranges.size() - 1;
	    	int left = 0;
	    	while(left <= right) {
	    		int mid = (left + right) / 2;
	    		Interval m = ranges.get(mid);
	    		if(m.start <= val && val <= m.end) return mid;
	    		if(m.start > val) right = mid - 1;
	    		if(m.end < val) left = mid + 1;
	    	}
	    	return left;
	    }
	    

	}
	
    public static void main(String[] args) {
    	SummaryRanges x = new SummaryRanges();
    	//1, 3, 7, 2, 6,
    	x.addNum(1);
    	x.addNum(3);
    	x.addNum(7);
    	x.addNum(2);
    	x.addNum(6);
    	x.addNum(9);
    	x.addNum(4);
    	System.out.println(x.getIntervals());
    	x.addNum(10);
    	System.out.println(x.getIntervals());
    }
}
