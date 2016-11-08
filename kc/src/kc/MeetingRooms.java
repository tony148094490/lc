package kc;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Comparator<Interval> comp = new Comparator<Interval>(){
        	@Override 
        	public int compare(Interval a, Interval b) {
        		if(a.start < b.start){
        			return -1;
        		} else if(a.start > b.start) {
        			return 1;
        		} else {
        			return a.end - b.end;
        		}
        	}
        };
        Arrays.sort(intervals, comp);
        for(int i = 1 ; i < intervals.length; i++) {
        	if(intervals[i].start < intervals[i-1].end) return false;
        }
        return true;
    }
}
