public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] sum = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) {
                    sum[0][0] = grid[0][0];
                } else if(i == 0 && j != 0) {
                    sum[i][j] = sum[i][j - 1] + grid[i][j];
                } else if(j == 0 && i != 0) {
                    sum[i][j] = sum[i - 1][j] + grid[i][j];
                } else {
                    sum[i][j] = Math.min(sum[i][j - 1] + grid[i][j], sum[i - 1][j] + grid[i][j]);
                }
            }
        }
        return sum[grid.length - 1][grid[0].length - 1];
    }
}
