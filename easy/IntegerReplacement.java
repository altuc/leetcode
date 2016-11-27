public class Solution {
    public int integerReplacement(int n) {
        long ln = (long) n;
        return integerReplacementHelper(ln, 0);
    }
    
    private int integerReplacementHelper(long n, int count) {
        if(n == 1) {
            return count;
        } else if(n % 2 == 0) {
            return integerReplacementHelper(n / 2, count + 1);
        } else {
            return Math.min(integerReplacementHelper(n + 1, count + 1), integerReplacementHelper(n - 1, count + 1));
        }
    }
}
