package kc;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	if(n == 0) return res;
    	if(n == 1) {
    		List<String> r = new ArrayList<String>();
    		r.add("Q");
    		res.add(r);
    		return res;
    	}
    	getNQueens(0,n,new ArrayList<Integer>(), res);
    	return res;
    }
    
    private void getNQueens(int cur, int n, List<Integer> curPuzzle, List<List<String>> res) {
    	if(cur == n) {
    		List<String> newSol = getSol(curPuzzle);
    		res.add(newSol);
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
    
    private List<String> getSol(List<Integer> placement) {
    	List<String> res = new ArrayList<String>();
    	for(int j = 0 ; j < placement.size(); j++) {
    		int x = placement.get(j);
    		StringBuilder sb = new StringBuilder();
    		for(int i = 0 ; i < placement.size(); i++) {
    			if(i == x) {
    				sb.append("Q");
    			} else {
    				sb.append(".");
    			}
    		}
    		res.add(sb.toString());
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	NQueens x = new NQueens();
    	List<List<String>> res = x.solveNQueens(4);
    	for(List<String> list : res) {
    		System.out.println();
    		for(String str : list) System.out.println(str);
    	}
	}
}
