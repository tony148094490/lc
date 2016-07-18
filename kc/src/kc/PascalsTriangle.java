package kc;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0) return res;
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        res.add(new ArrayList<Integer>(cur));
        List<Integer> newList = new ArrayList<Integer>();
        
        while(numRows > 1) {
        	newList.add(1);
        	cur = res.get(res.size()-1);
        	for(int i = 1 ; i < cur.size() ;i++){
        		newList.add(cur.get(i) + cur.get(i-1));
        	}
        	newList.add(1);
        	res.add(newList);
        	newList = new ArrayList<Integer>();
        	numRows--;
        }
        return res;
    }
    
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(rowIndex < 0) return res;
    	int[] dp = new int[rowIndex+1];
    	dp[0] = 1;
    	
    	int counter = 0;
    	while(counter < rowIndex) {
    		for(int i = counter+1;i>=1;i--){
    			dp[i] = dp[i] + dp[i-1];
    		}
    		counter++;
    	}
    	
    	for(Integer x : dp) {
    		res.add(x);
    	}

    	return res;
    }
    
    
	public static void main(String[] args) {
		PascalsTriangle x = new PascalsTriangle();
		System.out.println(x.getRow(4));
	}
}
