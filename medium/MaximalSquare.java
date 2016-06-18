public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] res = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for(int i = 1; i <= matrix.length; i++) {
            for(int j = 1; j <= matrix[0].length; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    res[i][j] = Math.min(Math.min(res[i - 1][j], res[i][j - 1]), res[i - 1][j - 1]) + 1;
                    max = Math.max(max, res[i][j]);
                }
            }
        }
        return max * max;
    }
}
