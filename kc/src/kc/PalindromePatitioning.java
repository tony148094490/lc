package kc;

import java.util.ArrayList;
import java.util.List;

public class PalindromePatitioning {
    public List<List<String>> partition(String s) {
        int[][] map = new int[s.length()][s.length()];
        
        // Populate map
        for(int i = 0 ; i < s.length();i++){
        	int l = i;
        	int r = i;
        	while(l<s.length() && l >=0 && r<s.length() && r>=0 && l <= r) {
        		if(s.charAt(l) != s.charAt(r)){
        			break;
        		}
        		map[l][r] = 1;
        		l--;
        		r++;
        	}
        	
        	l = i;
        	r = i + 1;
        	while(l<s.length() && l>=0 && r<s.length() && r >=0 && l <= r) {
        		if(s.charAt(l) != s.charAt(r)) {
        			break;
        		}
        		map[l][r] = 1;
        		l--;
        		r++;
        	}        	
        }
        for(int i = 0 ; i < map.length; i++){
        	for(int j = 0 ; j < map[0].length; j++){
        		System.out.print(map[i][j]);
        	}System.out.println();
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        
        populateRes(s,map,0,new ArrayList<String>(), res);
        
        
        return res;
    }
    
    private void populateRes(String s, int[][] map, int index, List<String> curRes, List<List<String>> res) {
    	if(index == s.length()) {
    		res.add(new ArrayList<String>(curRes));
    		return;
    	}
    	
    	for(int i = index; i < map.length ;i++){
    		if(map[index][i] == 1) {
    			curRes.add(s.substring(index,i+1));
    			populateRes(s,map,i+1,curRes,res);
    			curRes.remove(curRes.size()-1);
    		}
    	}
    }
    
    public static void main(String[] args) {
    	PalindromePatitioning x = new PalindromePatitioning();
    	System.out.println(x.partition("efe"));
	}
}
