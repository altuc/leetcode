/* binary search */
public class Solution1 {
    public boolean isPerfectSquare(int num) {
        if(num == 1) {
            return true;
        }
        long start = 1;
        long end = num / 2;
        while(start < end) {
            long mid = start + (end - start) / 2;
            if(mid * mid < num) {
                start = mid + 1;
            } else if(mid * mid > num) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return start * start == num;
    }
}

/* math */
public class Solution2 {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while(num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
