package kc;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

	public List<List<Integer>> getFactors(int n) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(n, 2, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int n, int number, List<Integer> cur, List<List<Integer>> res) {
    	if(n == 1) {
    		if (cur.size() > 1) {
    			List<Integer> newList = new ArrayList<Integer>(cur);
    			res.add(newList);
    		}
    		return;
    	}

    	for(int i = number; i <= n; i++) {
    		if(isAFactor(n, i)) {
    			cur.add(i);
    			helper(n/i, i, cur, res);
    			cur.remove(cur.size()-1);
    		}
    	}
    }
    private boolean isAFactor(int n, int m) {
    	if(m == 1 || m > n || n % m != 0) return false;
    	return true;
    }
    
    public static void main(String[] args) {
    	FactorCombinations x = new FactorCombinations();
    	System.out.println(x.getFactors(32));
    }
}
