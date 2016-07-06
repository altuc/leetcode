public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int len = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                len = Math.max(len, longestIncreasingPathHelper(matrix, i, j, cache, null));
            }
        }
        return len;
    }
    
    public int longestIncreasingPathHelper(int[][] matrix, int i, int j, int[][] cache, Integer pre) {
        if(i < 0 || i == matrix.length || j < 0 || j == matrix[0].length || (pre != null && matrix[i][j] <= pre)) {
            return 0;
        }
        if(cache[i][j] != 0) {
            return cache[i][j];
        }
        int temp = Math.max(longestIncreasingPathHelper(matrix, i - 1, j, cache, matrix[i][j]), longestIncreasingPathHelper(matrix, i + 1, j, cache, matrix[i][j]));
        temp = Math.max(longestIncreasingPathHelper(matrix, i, j - 1, cache, matrix[i][j]), temp);
        temp = Math.max(longestIncreasingPathHelper(matrix, i, j + 1, cache, matrix[i][j]), temp);
        cache[i][j] = temp + 1;
        return cache[i][j];
    }
}
