package kc;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int[] res = new int [s.length()];
        boolean[][] map = new boolean[s.length()][s.length()];
        
        for(int i = 0 ; i < s.length(); i++) {
        	res[i] = i;
        	for(int j = 0; j<=i; j++) {
        		if(s.charAt(i) == s.charAt(j) && (i == j || j + 1 == i || map[j+1][i-1])) {
        			map[j][i] = true;
        			res[i] = j == 0 ? 0 : Math.min(res[i], res[j-1] + 1);
        		}
        	}
        }
        return res[s.length()-1];
    }
    
    private boolean[][] getMap(String s) {
    	boolean[][] map = new boolean[s.length()][s.length()];
    	return map;
    }
}
