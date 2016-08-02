package kc;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(k > n) return res;
		helper(k,n,1,new ArrayList<Integer>(), res);
		return res;
    }
    
    private void helper(int k, int target, int cur, List<Integer> curRes, List<List<Integer>> res) {
    	if (k == 0 && target != 0) return;
    	
    	if (k == 0 && target == 0) {
    		res.add(new ArrayList<Integer>(curRes));
    		return;
    	}
    	
    	for(int i = cur; i <= 9 && i <= target; i++) {
    		curRes.add(i);
    		helper(k-1,target-i,i+1,curRes,res);
    		curRes.remove(curRes.size()-1);
    	}
    }
    public static void main(String[] args) {
    	CombinationSumIII x = new CombinationSumIII();
    	
    	System.out.println(x.combinationSum3(3, 9));
	}
}
