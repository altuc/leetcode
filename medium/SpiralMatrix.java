public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        while(true) {
            for(int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if(res.size() == m * n) {
                break;
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if(res.size() == m * n) {
                break;
            }
            right--;
            for(int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if(res.size() == m * n) {
                break;
            }
            bottom--;
            for(int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if(res.size() == m * n) {
                break;
            }
            left++;
        }
        return res;
    }
}
