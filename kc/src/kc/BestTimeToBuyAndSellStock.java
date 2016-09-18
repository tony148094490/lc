package kc;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int buy = 0;
        int sell = -1;
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[buy] && (sell == -1 || (res < prices[i] - prices[buy]))) {
                sell = i;
                res = prices[i] - prices[buy];
            } else if(prices[i] < prices[buy]) {
                buy = i;
            }
        }
        
        return res;
    }
    
    public int maxProfit2(int[] prices) {
        if(prices.length < 2) return 0;
    	int maxProfit = 0;
        int buy = 0;
        int maxSell = -1;
        for(int i = 1; i < prices.length; i++) {
        	if(maxSell != -1 && prices[i] < prices[maxSell]) {
        		maxProfit += (prices[maxSell] - prices[buy]);
        		buy = i;
        		maxSell = -1;
        	} else if(maxSell == -1) {
        		if(prices[i] > prices[buy]) {
        			maxSell = i;
        		} else {
        			buy = i;
        		}
        	} else if (prices[i] > prices[maxSell]) {
        		maxSell = i;
        	}
        } 
        if(maxSell != -1) maxProfit += (prices[maxSell] - prices[buy]);
        return maxProfit;
    }  
    //cool down
    public int maxProfit3(int[] prices) {
        if(prices.length < 2) return 0;
        int[] buys = new int[prices.length];
        int[] sells = new int[prices.length];
        int[] cools = new int[prices.length];

        buys[0] = (-1) * prices[0];
        sells[0] = Integer.MIN_VALUE;
        cools[0] = 0;
        
        for(int i = 1; i < prices.length; i++) {
        	buys[i] = Math.max(cools[i-1] - prices[i], buys[i-1]);
        	sells[i] = Math.max(buys[i-1] + prices[i], sells[i-1]);
        	cools[i] = Math.max(buys[i-1],Math.max(sells[i-1], cools[i-1]));
        }
        
        return sells[sells.length-1] < 0 ? 0 : sells[sells.length-1];
    }
    
    public int maxProfit4(int[] prices) {
    	if(prices.length <= 1) return 0;
    	int k = 2;
    	int[][] dp = new int[k+1][prices.length];
    	int highestRemainder = 0;
    	for(int i = 1; i <= k; i++) {
    		highestRemainder = 0 - prices[0];
    		for(int j = 1; j < prices.length; j++) {
    			dp[i][j] = Math.max(dp[i][j-1], highestRemainder + prices[j]);
    			highestRemainder = Math.max(highestRemainder, dp[i-1][j] - prices[j]);
    		}
    	}
    	return dp[k][prices.length-1];
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,4,2,5,7,2,4,9,0};
		BestTimeToBuyAndSellStock x = new BestTimeToBuyAndSellStock();
		System.out.println(x.maxProfit4(arr));
	}

}
