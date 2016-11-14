package kc;

import java.util.Arrays;
import java.util.List;

public class ZigZagIterator {

    List<Integer> listOne;
    List<Integer> listTwo;
    int firstPointer;
    int secondPointer;
    boolean first;
    
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        listOne = v1;
        listTwo = v2;
        firstPointer = 0;
        secondPointer = 0;
        first = true;
    }

    public int next() {
        if(firstPointer == listOne.size()) {
            int res = listTwo.get(secondPointer);
            secondPointer++;
            return res;
        } else if(secondPointer == listTwo.size()) {
            int res = listOne.get(firstPointer);
            firstPointer++;
            return res;
        }
        
        
        if(first) {
            int res = listOne.get(firstPointer);
            firstPointer++;
            first = false;
            return res;
        } else {
            int res = listTwo.get(secondPointer);
            secondPointer++;
            first = true;
            return res;
        }
    }

    public boolean hasNext() {
        if(firstPointer == listOne.size() && secondPointer == listTwo.size()) return false;
        return true;
    }
    
    public static void main(String[] args) {
    	List<Integer> arrA = Arrays.asList(1,2,3,4,5);
    	List<Integer> arrB = Arrays.asList(7,8,9,10,11,12,13);
    	ZigZagIterator  x = new ZigZagIterator(arrA, arrB);
    	while(x.hasNext()) {
    		System.out.print(x.next() + ",");
    	}
    	
	}
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
