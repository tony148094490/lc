package kc;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer>{
    Integer tempHolder = null;
    Iterator<Integer> curIterator = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    curIterator = iterator;
	    if(curIterator.hasNext()) {
	    	tempHolder = curIterator.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return tempHolder;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = tempHolder;
	    if(curIterator.hasNext()) {
	    	tempHolder = curIterator.next();
	    } else {
	    	tempHolder = null;
	    }
	    return res;
	}

	@Override
	public boolean hasNext() {
	    if(tempHolder != null) {
	        return true;
	    } else {
	    	return false;
	    }
	}
}
