public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while(j < nums.length) {
            sum += nums[j];
            j++;
            while(sum >= s) {
                len = Math.min(len, j - i);
                sum -= nums[i];
                i++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
