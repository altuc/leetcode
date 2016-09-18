public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int res = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            res += i * A[i];
            sum += A[i];
        }
        int fk = res;
        for(int i = n - 1; i > 0; i--) {
            fk = fk + sum - n * A[i];
            res = Math.max(res, fk);
        }
        return res;
    }
}
