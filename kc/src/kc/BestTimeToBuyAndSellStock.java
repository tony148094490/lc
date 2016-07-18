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
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,8,4,7,9,2,10};
		int[] arr1 = {7,6,4,3,1};
		BestTimeToBuyAndSellStock x = new BestTimeToBuyAndSellStock();
		System.out.println(x.maxProfit2(arr));
	}

}
