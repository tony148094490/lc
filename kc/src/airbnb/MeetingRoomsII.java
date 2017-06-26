package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import kc.Interval;

public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
    	if(intervals.length == 0) return 0;
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
        List<Interval> rooms = new ArrayList<Interval>();
        rooms.add(intervals[0]);
        for(int i = 1 ; i < intervals.length; i++) {
        	boolean needNewRoom = true;
        	for(int j = 0 ; j < rooms.size(); j++) {
        		if(rooms.get(j).end <= intervals[i].start){
        			needNewRoom = false;
        			rooms.set(j, intervals[i]);
        			break;
        		} 
        	}
        	if(needNewRoom) {
        		rooms.add(intervals[i]);
        	}
        }
        return rooms.size();
    }
}
