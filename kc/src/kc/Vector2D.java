package kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
	List<List<Integer>> list;
	Iterator<List<Integer>> rowIterator;
	Iterator<Integer> colIterator;
    public Vector2D(List<List<Integer>> vec2d) {
        list = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < vec2d.size(); i++) {
            if(vec2d.get(i).size() <= 0) continue;
            list.add(vec2d.get(i));
        }
        rowIterator = list.iterator();
        if(rowIterator.hasNext()) {
        	colIterator = rowIterator.next().iterator();
        }
    }

    @Override
    public Integer next() {
    	if(colIterator.hasNext()) {
    		return colIterator.next();
    	} else {
    		colIterator = rowIterator.next().iterator();
    		return colIterator.next();
    	}
    }

    @Override
    public boolean hasNext() {
        if(colIterator == null) return false;
    	if(!colIterator.hasNext() && !rowIterator.hasNext()) return false;
    	return true;
    }
    
    public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(new Integer[] {1,2,3,4,5});
		List<Integer> list2 = Arrays.asList(new Integer[] {6});
		List<Integer> list3 = Arrays.asList(new Integer[] {7,8,9});
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(list1);res.add(list2);res.add(list3);
		Vector2D x = new Vector2D(res);
		while(x.hasNext()) {
			System.out.println(x.next());
		}
		
	}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

