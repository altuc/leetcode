public class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int temp = x % 10;
            if((res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < temp)) && x > 0) {
                return 0;
            }
            if((res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && Integer.MIN_VALUE % 10 > temp)) && x < 0) {
                return 0;
            }
            res = 10 * res + temp;
            x /= 10;
        }
        return res;
    }
}
