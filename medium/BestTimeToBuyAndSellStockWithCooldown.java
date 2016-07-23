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

public class Solution3 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(prices[1] - prices[0], 0);
        for(int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        return sell[prices.length - 1];
    }
}
