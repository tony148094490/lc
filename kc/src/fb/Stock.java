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
}
