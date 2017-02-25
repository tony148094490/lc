package kc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer>{
    LinkedList<NestedInteger> q = new LinkedList<NestedInteger>();
	public NestedIterator(List<NestedInteger> nestedList) {
    	for(NestedInteger x : nestedList) q.add(x);
    }

    @Override
    public Integer next() {
        return q.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
        if(q.isEmpty()) return false;
    	if(q.peek().isInteger()) return true;
        while(!q.peek().isInteger()) {
        	List<NestedInteger> list = q.poll().getList();
            for(int i = list.size() -1 ; i >= 0 ; i--) {
            	q.add(0, list.get(i));
            }
        }	
        return true;
    }
}
