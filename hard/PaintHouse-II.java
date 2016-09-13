public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int min1 = -1, min2 = -1;
        for(int i = 0; i < costs.length; i++) {
            int pre1 = min1, pre2 = min2;
            min1 = -1;
            min2 = -1;
            for(int j = 0; j < costs[0].length; j++) {
                if(j != pre1) {
                    costs[i][j] += pre1 < 0 ? 0 : costs[i - 1][pre1];
                } else {
                    costs[i][j] += pre2 < 0 ? 0 : costs[i - 1][pre2];
                }
                if(min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else {
                    if(min2 < 0 || costs[i][j] < costs[i][min2]) {
                        min2 = j;
                    }
                }
            }
        }
        return costs[costs.length - 1][min1];
    }
}
