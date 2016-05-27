public class Solution1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}

public class Solution2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        str = str.replaceAll("0", "");
        return str.length();
    }
}
