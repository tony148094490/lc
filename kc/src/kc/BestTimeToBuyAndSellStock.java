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
	    int p = 0;
	    for(int i = 1 ; i < prices.length; i++) {
	        if(prices[i] >= prices[i-1]) p+= prices[i] - prices[i-1];
	    }
	    return p;
//    	int maxProfit = 0;
//        int buy = 0;
//        int maxSell = -1;
//        for(int i = 1; i < prices.length; i++) {
//        	if(maxSell != -1 && prices[i] < prices[maxSell]) {
//        		maxProfit += (prices[maxSell] - prices[buy]);
//        		buy = i;
//        		maxSell = -1;
//        	} else if(maxSell == -1) {
//        		if(prices[i] > prices[buy]) {
//        			maxSell = i;
//        		} else {
//        			buy = i;
//        		}
//        	} else if (prices[i] > prices[maxSell]) {
//        		maxSell = i;
//        	}
//        } 
//        if(maxSell != -1) maxProfit += (prices[maxSell] - prices[buy]);
//        return maxProfit;
    }
    
    
    //cool down
    public int maxProfit3(int[] prices) {
        if(prices.length == 0) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] cool = new int[prices.length];
        
        buy[0] = 0 - prices[0];
        cool[0] = 0;
        sell[0] = 0;
        
        for(int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1], cool[i-1] - prices[i]);
            cool[i] = Math.max(cool[i-1], sell[i-1]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return Math.max(sell[prices.length-1], cool[prices.length-1]);
    }
    
    public int maxProfit4(int[] prices, int k) {
        if(prices.length < 2) return 0;
        int[][] profit = new int[3][prices.length];
        for(int i = 1 ; i <= 2; i++) {
            int profitTillNowWithBuy = 0 - prices[0];
            for(int j = 1; j < prices.length; j++) {
                int newProfitTillNowWithBuy = Math.max(profitTillNowWithBuy, profit[i-1][j-1] - prices[j]);
                profit[i][j] = Math.max(profit[i][j-1], profitTillNowWithBuy + prices[j]);
                profitTillNowWithBuy = newProfitTillNowWithBuy;
            }
        }
        
        return profit[2][prices.length-1];
        }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,4,2,5,7,2,4,9,0};
		BestTimeToBuyAndSellStock x = new BestTimeToBuyAndSellStock();
		System.out.println(x.maxProfit4(arr, 2));
	}

}
