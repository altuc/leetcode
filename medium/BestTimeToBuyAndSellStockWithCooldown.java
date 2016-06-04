public class Solution1 {
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

public class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int b0 = -prices[0], b1 = b0, s0 = 0, s1 = 0, s2 = 0;
        for(int i = 1; i < prices.length; i++) {
            b0 = Math.max(s2 - prices[i], b1);
            s0 = Math.max(b1 + prices[i], s1);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }
}
