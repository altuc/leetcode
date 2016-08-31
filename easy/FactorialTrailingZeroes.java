public class Solution1 {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n > 1) {
            n /= 5;
            res += n;
        }
        return res;
    }
}

public class Solution2 {
    public int trailingZeroes(int n) {
        if(n < 5) {
            return 0;
        } else {
            return n / 5 + trailingZeroes(n / 5);
        }
    }
}
