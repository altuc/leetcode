public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if(nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        int[] rob1 = new int[nums.length - 1];
        int[] rob2 = new int[nums.length - 1];
        rob1[0] = nums[0];
        rob1[1] = Math.max(nums[0], nums[1]);
        rob2[0] = nums[1];
        rob2[1] = Math.max(nums[1], nums[2]);
        for(int i = 2; i < nums.length - 1; i++) {
            rob1[i] = Math.max(rob1[i - 2] + nums[i], rob1[i - 1]);
        }
        for(int i = 3; i < nums.length; i++) {
            rob2[i - 1] = Math.max(rob2[i - 3] + nums[i], rob2[i - 2]);
        }
        return Math.max(rob1[nums.length - 2], rob2[nums.length - 2]);
    }
}
