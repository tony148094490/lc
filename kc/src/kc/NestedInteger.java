package kc;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
		Integer x;
		List<NestedInteger> list;
	       // Constructor initializes an empty nested list.
	       public NestedInteger() {}
	  
	       // Constructor initializes a single integer.
	       public NestedInteger(int value) {
	    	   x = value;
	       }
	  
	       // @return true if this NestedInteger holds a single integer, rather than a nested list.
	       public boolean isInteger() {
	    	   return list == null;
	       }
	  
	       // @return the single integer that this NestedInteger holds, if it holds a single integer
	       // Return null if this NestedInteger holds a nested list
	       public Integer getInteger() {
	    	   return x;
	       }
	  
	       // Set this NestedInteger to hold a single integer.
	       public void setInteger(int value) {
	    	   x = value;
	       }
	  
	       // Set this NestedInteger to hold a nested list and adds a nested integer to it.
	       public void add(NestedInteger ni) {
	    	   if(list == null) {
	    		   list = new ArrayList<NestedInteger>();
	    	   }
	    	   list.add(ni);
	       }
	  
	       // @return the nested list that this NestedInteger holds, if it holds a nested list
	       // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList(){
	    	  return new ArrayList<NestedInteger>();
	      }
	      
	      public String toString() {
	    	  if(isInteger()) {
	    		  if(x == null) return "";
	    		  return x.toString();
	    	  } else {
	    		  return list.toString();
	    	  }
	      }
}
	 

