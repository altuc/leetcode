public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max, min;
        int premax = nums[0], premin = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            max = Math.max(Math.max(premax * nums[i], premin * nums[i]), nums[i]);
            min = Math.min(Math.min(premax * nums[i], premin * nums[i]), nums[i]);
            res = Math.max(res, max);
            premax = max;
            premin = min;
        }
        return res;
    }
}
