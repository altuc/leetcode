public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int buy = -prices[0], hold = 0, sell = 0, noHold = 0;
        for(int i = 1; i < prices.length; i++) {
            hold = buy;
            buy = Math.max(noHold - prices[i], hold);
            noHold = sell;
            sell = Math.max(hold + prices[i], noHold);
        }
        return sell;
    }
}
