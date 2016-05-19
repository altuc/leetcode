public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }
        int[][] res = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            if(obstacleGrid[i][0] == 0) {
                res[i][0] = 1;
            } else {
                break;
            }
        }
        for(int i = 0; i < cols; i++) {
            if(obstacleGrid[0][i] == 0) {
                res[0][i] = 1;
            } else {
                break;
            }
        }
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(obstacleGrid[i - 1][j] == 0) {
                    res[i][j] = res[i - 1][j];
                }
                if(obstacleGrid[i][j - 1] == 0) {
                    res[i][j] = res[i][j] + res[i][j - 1];
                }
            }
        }
        return res[rows - 1][cols - 1];
    }
}
