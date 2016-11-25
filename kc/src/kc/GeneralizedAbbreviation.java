package kc;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", 
"1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
one 
0 , 1 , 2, 3, 4
two
11, 12,13,14
21,22,23,24
31,32,33,34
three
plus 1, 2, 3, 4


 */
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        construct(word, 0, "", 0, res);
        return res;
    }
    private void construct(String word, int position, String cur, int counter, List<String> res) {
    	if(position == word.length()) {
    		if(counter > 0) cur+=String.valueOf(counter);
    		res.add(cur);
    	} else {
    		construct(word, position+1, cur, counter+1, res);
    		if(counter == 0) {
    			construct(word,position+1, cur+word.charAt(position), counter, res);
    		} else {
    			construct(word,position+1, cur+String.valueOf(counter)+word.charAt(position), 0, res);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	GeneralizedAbbreviation x = new GeneralizedAbbreviation();
    	System.out.println(x.generateAbbreviations("word"));
	}
}
