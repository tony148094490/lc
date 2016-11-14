package kc;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < s.length()-1; i++) {
        	if(s.charAt(i) == '+' && s.charAt(i+1) == '+') {
        		arr[i] = '-';
        		arr[i+1] = '-';
        		res.add(new String(arr));
        		arr[i] = '+';
        		arr[i+1] = '+';
        	}
        }
        return res;
    }
    
    
    
    
    public static void main(String[] args) {
		String s = "++++";
		FlipGame x = new FlipGame();
		System.out.println(x.generatePossibleNextMoves(s));
	}
}
