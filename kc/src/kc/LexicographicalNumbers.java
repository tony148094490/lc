package kc;

import java.util.ArrayList;
import java.util.List;

/**
 * n = 451
 * 
 *           4 --- > 5 ---> 6 ---> ... 9
 *         /
 *        /
 *      40 -> 41 -> ...-> 45 -> ... -> 49
 *     /      /          / 
 *   400.. 410->411..  450->451
 */


public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        int cur = 1;
        res.add(cur);
        for(int counter = 2; counter <= n; counter++) {
        	// go to the child until it cannot 
            if(cur * 10 <= n) {
                cur = cur * 10;
                res.add(cur);
            // go to the next peer until reaches 9 which is the end of current level
            } else if(cur % 10 != 9 && cur + 1 <= n) {
                cur = cur + 1;
                res.add(cur);
            } else {
                // go back to one level up first and see if it's at the end and needs to go back again.
        	    cur = cur / 10;
            	while( cur % 10 == 9) cur = cur / 10;
        		cur = cur + 1;
        		res.add(cur);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
    	LexicographicalNumbers x = new LexicographicalNumbers();
    	System.out.println(x.lexicalOrder(192));
	}
}
