package kc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PhoneDirectory {
    Set<Integer> set = new HashSet<Integer>();
    LinkedList<Integer> list = new LinkedList<Integer>();
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        for(int i = 0 ; i< maxNumbers; i++){
        	list.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(list.isEmpty()) return -1;
        int res = list.poll();
        set.add(res);
        return res;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
    	if(!set.contains(number)) return;
        set.remove(number);
        list.add(number);
    }
    
    public static void main(String[] args) {
    	PhoneDirectory x = new PhoneDirectory(3);
    	System.out.println(x.get());
    	System.out.println(x.get());
    	System.out.println(x.check(2));
    	System.out.println(x.get());
    	System.out.println(x.check(2));
    	x.release(2);
    	System.out.println(x.check(2));
    	
	}
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */