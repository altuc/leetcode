public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int temp = 0;
        int max = 0;
        int min = prices[0];
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            } 
            if(prices[i] - min > temp) {
                temp = prices[i] - min;
                max = prices[i];
            }
            if(prices[i] < max) {
                profit += temp;
                max = 0;
                temp = 0;
                min = prices[i];
            }
        }
        profit += temp;
        return profit;
    }
}