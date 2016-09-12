package kc;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    public int totalNQueens(int n) {
    	if(n <= 1) return n;
    	List<Integer> res = new ArrayList<Integer>();
    	getNQueens(0,n,new ArrayList<Integer>(), res);
    	return res.size();
    }
    
    private void getNQueens(int cur, int n, List<Integer> curPuzzle, List<Integer> res) {
    	if(cur == n) {
    		res.add(1);
    	} else {
    		for(int i = 0 ; i < n ; i++){
    				if(curPuzzle.size() == 0) {
    					curPuzzle.add(i);
    					getNQueens(cur+1,n,curPuzzle, res);
    					curPuzzle.remove(curPuzzle.size()-1);
    				} else {
	    				if (!validMove(curPuzzle, i)) continue;
	    				curPuzzle.add(i);
	    				getNQueens(cur+1, n, curPuzzle, res);
	    				curPuzzle.remove(curPuzzle.size()-1);
    				}
    		}
    	}
    }
    
    private boolean validMove(List<Integer> list , int cur) {
    	int row = list.size();
    	for(int i = 0 ; i < list.size(); i++) {
    		int x = list.get(i);
    		if(x == cur || cur + row - i == x || cur - (row - i) == x) return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	NQueensII x = new NQueensII();
    	System.out.println(x.totalNQueens(4));
	}
}
