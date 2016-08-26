public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for(int i = 0; i < res.length; i++) {
            for(int k = 0; k < A[0].length; k++) {
                if(A[i][k] != 0) {
                    for(int j = 0; j < res[0].length; j++) {
                        if(B[k][j] != 0) {
                            res[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return res;
    }
}
