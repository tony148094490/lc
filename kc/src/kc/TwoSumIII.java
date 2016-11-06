package kc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumIII {
	List<Integer> list = new ArrayList<Integer>();
	Set<Integer> visited = new HashSet<Integer>();
    // Add the number to an internal data structure.
	public void add(int number) {
		list.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		if(visited.contains(value)) return true;
	    Set<Integer> set = new HashSet<Integer>();
	    for(int i = 0 ; i < list.size(); i++) {
	    	if(set.contains(list.get(i))){
	    		visited.add(value);
	    		return true;
	    	}
	    	set.add(value - list.get(i));
	    }
	    return false;
	}
}


//Your TwoSum object will be instantiated and called as such:
//TwoSum twoSum = new TwoSum();
//twoSum.add(number);
//twoSum.find(value);