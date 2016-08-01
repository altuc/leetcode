public class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[][] res = new int[nums.length][nums.length];
        for(int len = 1; len <= nums.length; len++) {
            for(int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                for(int k = i; k <= j; k++) {
                    int left = 1;
                    int right = 1;
                    if(i != 0) {
                        left = nums[i - 1];
                    }
                    if(j != nums.length - 1) {
                        right = nums[j + 1];
                    }
                    int before = 0;
                    int after = 0;
                    if(k != i) {
                        before = res[i][k - 1];
                    }
                    if(k != j) {
                        after = res[k + 1][j];
                    }
                    res[i][j] = Math.max(res[i][j], left * nums[k] * right + before + after);
                }
            }
        }
        return res[0][nums.length - 1];
    }
}
