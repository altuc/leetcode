public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length, m = grid[0].length, count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    numIslandsHelper(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void numIslandsHelper(char[][] grid, int i, int j) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir : dirs) {
            numIslandsHelper(grid, i + dir[0], j + dir[1]);
        }
    }
}
