package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * trick is the linked hash set
 */
public class RandomizedCollection {
	 final Random rand = new Random();
	 List<Integer> list;
	 Map<Integer, Set<Integer>> map;
   /** Initialize your data structure here. */
   public RandomizedCollection() {
       list = new ArrayList<Integer>();
       map = new HashMap<Integer, Set<Integer>>();
   }
   
   /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
   public boolean insert(int val) {
       if(map.containsKey(val)) {
       	map.get(val).add(list.size());
       	list.add(val);
       	return false;
       } else {
       	Set<Integer> l = new LinkedHashSet<Integer>();
       	l.add(list.size());
       	map.put(val, l);
       	list.add(val);
       	return true;
       }
   }
   
   /** Removes a value from the collection. Returns true if the collection contained the specified element. */
   public boolean remove(int val) {
       if(!map.containsKey(val)) return false;
       
       Set<Integer> positions = map.get(val);
       int index = positions.iterator().next();
       positions.remove(index);
       
       int last = list.get(list.size()-1);
       Set<Integer> lasts = map.get(last);
       
       list.set(index, last);
       
       // this is tricky
       if(index != list.size()-1) {
    	   // do an index-replace if they are different.
    	   // if it's the same, it means the last position was already removed (updated)
           lasts.remove(list.size()-1);
           lasts.add(index);        	
       }
       
       list.remove(list.size()-1);
       if(positions.size() == 0) {
       	map.remove(val);
       }
       
       return true;
   }
   
   /** Get a random element from the collection. */
   public int getRandom() {
      return list.get(rand.nextInt(list.size())); 
   }
    
    public static void main(String[] args) {
    	RandomizedCollection x = new RandomizedCollection();
    	x.insert(0);
    	x.insert(1);
    	x.insert(2);
    	x.insert(3);
    	x.insert(3);

    	x.remove(2);
    	
    	System.out.println(x.list);
    	System.out.println(x.map);
    	System.out.println();
    	
    	
    	x.remove(3);
    	System.out.println(x.list);
    	System.out.println(x.map);
    	System.out.println();
    	
    	x.remove(0);
    	System.out.println(x.list);
    	System.out.println(x.map);
    	System.out.println();
    	

    }
}



/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
