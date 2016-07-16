package kc;

public class UniqueBinarySearchTree {
    public int numTrees(int n) {
    	if(n <= 1) return n;
    	
    	int[] dp = new int[n+1];
    	
    	dp[0] = 1;
    	dp[1] = 1;
    		
    	for(int i = 2 ; i <=n ; i++) {
    		for(int j = 0 ; j < i; j++) {
    			dp[i] += dp[j] * dp[i- 1 - j];
    		}
    	}
    	
    	return dp[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTree x = new UniqueBinarySearchTree();
		System.out.println(x.numTrees(4));
	}

}
