public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int[] res = new int[amount + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i && res[i - coins[j]] != Integer.MAX_VALUE) {
                    res[i] = Math.min(res[i], res[i - coins[j]] + 1);
                }
            }
        }
        return res[amount] == Integer.MAX_VALUE ? -1 : res[amount];
    }
}
