package kc;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || k > n) return res;
        
        getComb( k, 1,n, new ArrayList<Integer>(), res);
        
        return res;
        
    }
    
    private void getComb(int k, int curIndex, int n, List<Integer> curRes, List<List<Integer>> res) {
    	if(curRes.size() == k) {
    		res.add(new ArrayList<Integer>(curRes));
    	}
    	
    	for(int i = curIndex; i <= n; i++){
    		curRes.add(i);
    		getComb(k,i+1,n,curRes,res);
    		curRes.remove(curRes.size() - 1);
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations x = new Combinations();
		System.out.println(x.combine(4, 2));
	}

}
