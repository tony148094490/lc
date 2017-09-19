package fb;
//1 2 3 4 and sell must sell all, with commission fees
public class Stock {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[][] sell = new int[3][prices.length];
        for(int i = 1; i <= 2; i++) {
            int initialBuy = -prices[0];
            for(int j = 1; j < prices.length; j++) {
                sell[i][j] = Math.max(sell[i][j-1], prices[j] + initialBuy);
                initialBuy = Math.max(initialBuy, sell[i-1][j-1] - prices[j]);
            }
        }
        return sell[2][prices.length-1];
    }
    
    public int maxProfitWithCharge(int[] prices, int charge) {
        int profit = 0;
        int localProfit = 0;
        boolean yesterdaySold = false;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                localProfit += prices[i] - prices[i - 1];
                if (!yesterdaySold) {
                    localProfit -= charge;
                }
                yesterdaySold = true;
            }
            else if (yesterdaySold) {
                profit += localProfit > 0 ? localProfit : 0;
                localProfit = 0;
                yesterdaySold = false;
            }
            
            if (localProfit > 0) {
                profit += localProfit;
            }
        }

        return profit;
    }
}
