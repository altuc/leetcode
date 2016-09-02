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
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) == num;
    }
}

public class Solution3 {
    public boolean isPowerOfFour(int num) {
        return (Math.log10(num) / Math.log10(4)) % 1 == 0;
    }
}
