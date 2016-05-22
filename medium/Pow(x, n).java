public class Solution1 {
    public double myPow(double x, int n) {
        if(x == 0.00) {
            return 0.00;
        }
        if(x == 1.00) {
            return 1.00;
        }
        if(x == -1.00) {
            if(n % 2 == 0) {
                return 1.00;
            } else {
                return -1.00;
            }
        }
        if(n == 0) {
            return 1.00;
        }
        if(n == Integer.MIN_VALUE) {
            return 0.00;
        }
        double result = x;
        int m = n > 0? n : -n;
        for(int i = 1; i < m; i++) {
            if(result == result * x) {
                break;
            }
            result *= x;
        }
        return n > 0? result : 1 / result;
    }
}

public class Solution2 {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1.00;
        }
        if(n < 0) {
            n = -n;
            x = 1 / x;
        }
        double tmp = myPow(x * x, n / 2);
        return n % 2 == 0? tmp : x * tmp;
    }
}
