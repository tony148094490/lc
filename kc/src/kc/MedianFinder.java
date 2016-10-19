package kc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	
	Comparator<Integer> comp = new Comparator<Integer>(){
		@Override
		public int compare(Integer a, Integer b) {
			if (a > b) {
				return -1;
			} else if(a < b) {
				return 1;
			}
			return 0;
		}
	};
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(comp);
	
	Integer median = null;
	
    // Adds a number into the data structure.
    public void addNum(int num) {
    	if(minHeap.isEmpty() && maxHeap.isEmpty() && median == null) {
    		median = num;
    		return;
    	}
    	
    	if(minHeap.isEmpty()) {
    		if(num >= median) {
    			minHeap.offer(num);
    			maxHeap.offer(median);
    		} else {
    			maxHeap.offer(num);
    			minHeap.offer(median);
    		}
    		median = null;
    		return;
    	}
    	
    	int min = minHeap.peek();
    	int max = maxHeap.peek();
    	if(median == null) {
    		if(num >= min) {
    			median = minHeap.poll();
    			minHeap.offer(num);
    		} else if(num <= max) {
    			median = maxHeap.poll();
    			maxHeap.offer(num);
    		} else {
    			median = num;
    		}
    	} else {
    		if(num >= median) {
    			minHeap.offer(num);
    			maxHeap.offer(median);
    		} else { 
    			minHeap.offer(median);
    			maxHeap.offer(num);
    		}
			median = null;
    	} 	
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(median != null) return median;
        return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
    
    public static void main(String[] args) {
    	MedianFinder x = new MedianFinder();
    	for(int i = -1 ; i >= -5; i--) {
    		x.addNum(i);

    		System.out.println(x.findMedian());
    	}
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();



