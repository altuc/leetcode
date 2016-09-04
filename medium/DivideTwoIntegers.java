public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if(dividend < 0 != divisor < 0) {
            sign = -1;
        }
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        if(lDivisor == 0) {
            return Integer.MAX_VALUE;
        }
        if(lDividend == 0 || lDividend < lDivisor) {
            return 0;
        }
        long lRes = divideHelper(lDividend, lDivisor);
        if(lRes > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return (int) (sign * lRes);
        }
    }
    
    public long divideHelper(long dividend, long divisor) {
        if(dividend < divisor) {
            return 0;
        }
        long sum = divisor;
        long times = 1;
        while(sum + sum < dividend) {
            sum += sum;
            times += times;
        }
        return times + divideHelper(dividend - sum, divisor);
    }
}
