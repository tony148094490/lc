package kc;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	
	String[] alphabets = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
    public List<String> letterCombinations(String digits) {
    
    	List<String> list = new ArrayList<String>();
    	if(digits.length() == 0) return list;
    	helper(digits, new String(), list);
    	return list;
    }
    
    private void helper(String digits, String current, List<String> result) {
    	
    	if(digits.length() == 0) {
    		result.add(current);
    		return;
    	}
    	
    	char c = digits.charAt(0);
    	String alphabet = alphabets[c - '0'];
    	if(alphabet.length() == 0) helper(digits.substring(1), current, result);
    	for(Character ch : alphabet.toCharArray()) {
    		helper(digits.substring(1), current+ch, result);
    	}

    }
    
    public static void main(String[] args) {
    	LetterCombinationsOfPhoneNumber l = new LetterCombinationsOfPhoneNumber();
    	System.out.println(l.letterCombinations("92"));
    }
}
