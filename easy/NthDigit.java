public class Solution {
    public int findNthDigit(int n) {
        int count = 1;
        long unit = 9;
        while(n > count * unit) {
            n -= count * unit;
            count++;
            unit *= 10;
        }
        int remain = n;
        int res = 1;
        int i = 0;
        unit /= 9;
        while(i <= (remain - 1) % count) {
            if(i != 0) {
                res = 0;
            }
            while(n > count * unit) {
                n -= count * unit;
                res++;
            }
            unit /= 10;
            i++;
        }
        return res;
    }
}
