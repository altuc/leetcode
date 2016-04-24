public class Solution1 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            res |= (sum % 3) << i;
        }
        return res;
    }
}

public class Solution2 {
    public int singleNumber(int[] nums) {
        // Java integer size is 32 bit 
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) != 0)
                    sum++;
            }
            if (sum % 3 != 0)
                result |= (sum % 3) << i;
        }
        return result;
    }
}
