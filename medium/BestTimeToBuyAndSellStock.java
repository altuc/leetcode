public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int res = 0, min = prices[0];
        for(int price : prices) {
            res = Math.max(res, price - min);
            min = Math.min(min, price);
        }
        return res;
    }
}
