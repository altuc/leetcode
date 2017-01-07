public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0, len = nums.length;
        for(int i = 0; i < len; i++) {
            if(max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
