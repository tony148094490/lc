package kc;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n < 1) return res;
        res.add(1);
        int cur = 1;
        for(int i = 2; i <= n ; i++) {
        	if(cur * 10 <= n) {
        		cur = cur * 10;
        		res.add(cur);
        	}else if(cur % 10 != 9 && cur + 1 <= n) {
        		cur = cur + 1;
        		res.add(cur);
        	} else {
        		if(cur % 10 == 9) {
            		while( cur % 10 == 9 ) cur = cur / 10;
        		} else {
        			cur = cur / 10;
        		}
        		cur = cur + 1;
        		res.add(cur);
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
    	LexicographicalNumbers x = new LexicographicalNumbers();
    	System.out.println(x.lexicalOrder(13));
	}
}
