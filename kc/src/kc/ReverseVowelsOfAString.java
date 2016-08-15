package kc;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');vowels.add('A');
        vowels.add('e');vowels.add('E');
        vowels.add('i');vowels.add('I');
        vowels.add('o');vowels.add('O');
        vowels.add('u');vowels.add('U');
        
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while(i < j) {
        	while(i < j && !vowels.contains(arr[i])) {
        		i++;
        	}
        	
        	while(i < j && !vowels.contains(arr[j])) {
        		j--;
        	}
        	
        	if(i < j){
	            char temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	            i++;
	            j--;
        	}
        }
        return new String(arr);
    }
}
