package kc;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    	if(s.length() <= 2) return s.length();
    	int res = 2;
    	Point a = new Point(s.charAt(0));
    	a.start = 0;
    	a.end = 0;
    	int index = 1;
    	List<Point> points = new ArrayList<Point>();
    	points.add(a);
    	while(index < s.length() && points.size() <= 2) {
    		if(s.charAt(index) == points.get(0).value ||
    				(points.size() > 1 && points.get(1).value == s.charAt(index))) {
    			if(s.charAt(index) == points.get(0).value) {
    				points.get(0).end = index;
    			} else {
    				points.get(1).end = index;
    			}
    		} else if (points.size() > 1) {
    			break;
    		} else {
    			Point newPoint = new Point(s.charAt(index));
    			newPoint.start = newPoint.end = index;
    			points.add(newPoint);
    		}
    		index++;
    	}
    	if(index == s.length()) return s.length();
    	res = Math.max(points.get(0).end, points.get(1).end) + 1;
    	
    	for(;index < s.length(); index++) {
    		if(s.charAt(index) == points.get(0).value || (points.size()>1 &&
    				points.get(1).value == s.charAt(index))) {
    			if(s.charAt(index) == points.get(0).value) {
    				points.get(0).end = index;
    			} else {
    				points.get(1).end = index;
    			}
    		} else {
    			Point newPoint = new Point(s.charAt(index));
    			newPoint.start = newPoint.end = index;
    			char last = s.charAt(index-1);
    			if(points.get(0).value == last) {
    				points.get(0).start = points.get(1).end + 1;
    				points.set(1, newPoint);
    			} else {
    				points.get(1).start = points.get(0).end + 1;
    				points.set(0, newPoint);
    			}
    		}
    		res  = Math.max(res, Math.max(points.get(0).end, points.get(1).end) - 
    				Math.min(points.get(0).start, points.get(1).start) + 1 );
    	}
        return res;
    }
    
    public class Point {
    	char value;
    	int start;
    	int end;
    	public Point(char v) {
    		value = v;
    	}
    	@Override
    	public String toString() {
    		return "[value: " + value + ", start: " + start + ", end: " + end + "]"; 
    	}
    }
    
    public static void main(String[] args) {
    	LongestSubstringWithAtMostTwoDistinctCharacters x = new LongestSubstringWithAtMostTwoDistinctCharacters();
    	String a = "aabbaacccc";
    	System.out.println(x.lengthOfLongestSubstringTwoDistinct(a));
    }
}
