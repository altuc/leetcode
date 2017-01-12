public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] res = new int[m][n];
        res[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for(int i = m - 2; i >= 0; i--) {
            res[i][n - 1] = Math.max(1, res[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for(int j = n - 2; j >= 0; j--) {
            res[m - 1][j] = Math.max(1, res[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                int down = Math.max(1, res[i + 1][j] - dungeon[i][j]);
                int right = Math.max(1, res[i][j + 1] - dungeon[i][j]);
                res[i][j] = Math.min(down, right);
            }
        }
        return res[0][0];
    }
}
