package kc;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        
    	
    	Comparator<String> com = new Comparator<String>() {
    		public int compare(String a, String b) {
    			String str1 = a+b;
    			String str2 = b+a;
    			return str1.compareTo(str2);
    		}
    	};
    	
    	String[] arr = new String[nums.length];
    	int i = 0;
    	for(Integer x : nums) {
    		arr[i] = String.valueOf(x);
    		i++;
    	}
    	Arrays.sort(arr, com);
    	if(arr[arr.length-1].equals("0")) return "0";
    	
    	StringBuilder sb = new StringBuilder();
    	for(i = arr.length-1;i>=0;i--){
    		sb.append(arr[i]);
    	}
    	
    	return sb.toString();
    }
    
    


    
    public static void main(String[] args) {

	}
    
}
