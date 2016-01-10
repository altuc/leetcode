public class Solution1 {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) {
            return false;
        }
        while(n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}

public class Solution2 {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) {
            return false;
        }
        if(n == 1) {
            return true;
        }
        if(n % 3 == 0) {
            return isPowerOfThree(n/3);
        } else {
            return false;
        }
    }
}

public class Solution3 {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n)/Math.log10(3)) % 1 == 0;
    }
}
