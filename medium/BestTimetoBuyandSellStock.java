public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int min = prices[0];
        for(int i = 0; i < prices.length; i++) {
            if(min > prices[i]) {
                min = prices[i];
            }
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}