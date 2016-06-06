public class NumMatrix {
    
    private int[][] sums = null;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sums = new int[matrix.length][matrix[0].length];
        sums[0][0] = matrix[0][0];
        for(int i = 1; i < matrix.length; i++) {
            sums[i][0] = sums[i - 1][0] + matrix[i][0];
        }
        for(int i = 1; i < matrix[0].length; i++) {
            sums[0][i] = sums[0][i - 1] + matrix[0][i];
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] + matrix[i][j] - sums[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0) {
            return sums[row2][col2];
        } else if(row1 == 0) {
            return sums[row2][col2] - sums[row2][col1 - 1];
        } else if(col1 == 0) {
            return sums[row2][col2] - sums[row1 - 1][col2];
        } else {
            return sums[row2][col2] - sums[row2][col1 - 1] - sums[row1 - 1][col2] + sums[row1 - 1][col1 - 1];
        }
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
