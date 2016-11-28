package kc;

import java.util.LinkedList;

public class MovingAverageFromDataStream {
    double sum = 0;
    int limit = 0;
    LinkedList<Integer> list;
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        limit = size;
        list = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if(list.size() == limit) {
            int first = list.removeFirst();
            sum -= first;
            sum += val;
            return sum / limit;
        } else {
        	list.add(val);
        	sum += val;
        	return sum / list.size();
        }
    }
    
    public static void main(String[] args) {
    	MovingAverageFromDataStream x = new MovingAverageFromDataStream(3);
    	System.out.println(x.next(1));
    	System.out.println(x.next(10));
    	System.out.println(x.next(3));
    	System.out.println(x.next(5));
    	
	}
}
