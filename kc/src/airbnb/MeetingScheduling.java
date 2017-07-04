package airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 第一轮高频，给N个人的busy time interval，让你找出所有人都有空的time interval。
public class MeetingScheduling {
	public List<Interval> get(List<List<Interval>> calendars) {
		List<Interval> schedules = new ArrayList<>();
		for(List<Interval> list : calendars) schedules.addAll(list);
	
		Comparator<Interval> comp = (a, b) -> {return a.start - b.start;};
		Collections.sort(schedules, comp);
		List<Interval> res = new ArrayList<>();
		for(int i = 1; i < schedules.size(); i++) {
			Interval last = schedules.get(i-1);
			Interval cur = schedules.get(i);
			if(cur.start > last.end) {
				Interval freeSlot = new Interval(last.end, cur.start);
				res.add(freeSlot);
			} else {
				cur.end = Math.max(cur.end, last.end);
			}
		}
		return res;
	}
	
	public static class Interval {
		int start;
		int end;
		public Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	
    public static void main(String[] args) {
    	MeetingScheduling sol = new MeetingScheduling();
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(4,7);
        Interval i3 = new Interval(4,11);
        Interval i4 = new Interval(13, 15);
        Interval i5 = new Interval(5,7);
        List<List<Interval>> busyTimes = new ArrayList<>();
        List<Interval> person1 = new ArrayList<>();
        List<Interval> person2 = new ArrayList<>();
        List<Interval> person3 = new ArrayList<>();
        person1.add(i1);
        person1.add(i2);
        person2.add(i3);
        person2.add(i4);
        person3.add(i5);
        busyTimes.add(person1);
        busyTimes.add(person2);
        busyTimes.add(person3);
        for (Interval i : findCommonSpareTime(busyTimes)) {
            System.out.println(i.start + ", " + i.end + " ");
        }
        
        List<Interval> res = sol.get(busyTimes);
        for(Interval i : res) {
        	System.out.println(i.start + ", " + i.end + " ");
        }
    }

    public static List<Interval> findCommonSpareTime(List<List<Interval>> times) {
        if (times == null || times.size() == 0) return Collections.emptyList();
        List<Interval> allIntervals = new ArrayList<>();
        for (List<Interval> intervals : times) {
            for (Interval interval : intervals) {
                allIntervals.add(interval);
            }
        }
        Collections.sort(allIntervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        List<Interval> allSpare = new ArrayList<>();
        Interval cursorInterval = allIntervals.get(0);
        for (int i = 1; i < allIntervals.size(); i++) {
            if (cursorInterval.end >= allIntervals.get(i).start) {
                cursorInterval.end = Math.max(allIntervals.get(i).end, cursorInterval.end);
            } else {
                // We find a spare time interval, add to result
                allSpare.add(new Interval(cursorInterval.end, allIntervals.get(i).start));
                cursorInterval = allIntervals.get(i);
            }
        }
        return allSpare;
    }
	

}
