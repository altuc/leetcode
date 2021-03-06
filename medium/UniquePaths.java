public class Solution1 {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        int[][] paths = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }
}

public class Solution2 {
    public int uniquePaths(int m, int n) {
        int[] rows = new int[m];
        rows[0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < m; j++) {
                rows[j] = rows[j - 1] + rows[j];
            }
        }
        return rows[m - 1];
    }
}

public class Solution3 {
    public int uniquePaths(int m, int n) {
        int total = m + n - 2;
        int target = m < n ? n : m;
        int base = m < n ? m - 1 : n - 1;
        double x = 1;
        double y = 1;
        for(int i = 1; i <= base; i++) {
            x *= i;
        }
        for(int i = total; i >= target; i--) {
            y *= i;
        }
        return (int)(y / x);
    }
}
