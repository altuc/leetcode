public class Solution1 {
    public boolean isPowerOfFour(int num) {
        if(num <= 0) {
            return false;
        }
        while(num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }
}

public class Solution2 {
    public boolean isPowerOfFour(int num) {
    // 0x55555555 = 01010101010101010101010101010101
        return ((num & (num - 1)) == 0) && (num > 0) && ((num & 0x55555555) == num);
    }
}
