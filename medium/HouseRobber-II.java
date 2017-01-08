public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] notRobLast = new int[len];
        notRobLast[0] = nums[0];
        notRobLast[1] = Math.max(nums[0], nums[1]);
        int[] robLast = new int[len];
        robLast[0] = 0;
        robLast[1] = nums[1];
        for(int i = 2; i < len; i++) {
            notRobLast[i] = Math.max(notRobLast[i - 2] + nums[i], notRobLast[i - 1]);
            robLast[i] = Math.max(robLast[i - 2] + nums[i], robLast[i - 1]);
        }
        return Math.max(notRobLast[len - 2], robLast[len - 1]);
    }
}
