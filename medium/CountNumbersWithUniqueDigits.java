public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        int res = 1;
        for(int i = 1; i <= n; i++) {
            int temp = 9;
            for(int j = 2; j <= i; j++) {
                temp = temp * (9 - j + 2);
            }
            res = res + temp;
        }
        return res;
    }
}
