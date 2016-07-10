public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        int rowMax = 0;
        int[] colMax = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(j == 0 || grid[i][j - 1] == 'W') {
                    rowMax = 0;
                    for(int k = j; k < grid[0].length && grid[i][k] != 'W'; k++) {
                        if(grid[i][k] == 'E') {
                            rowMax += 1;
                        }
                    }
                }
                if(i == 0 || grid[i - 1][j] == 'W') {
                    colMax[j] = 0;
                    for(int k = i; k < grid.length && grid[k][j] != 'W'; k++) {
                        if(grid[k][j] == 'E') {
                            colMax[j] += 1;
                        }
                    }
                }
                if(grid[i][j] == '0') {
                    max = Math.max(max, rowMax + colMax[j]);
                }
            }
        }
        return max;
    }
}
