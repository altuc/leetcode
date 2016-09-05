public class Solution1 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return true;
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}

public class Solution2 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return true;
        }
        int i = 0;
        int max = 0;
        while(max < nums.length - 1) {
            if(nums[max] == 0 && i == max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
            i++;
        }
        return true;
    }
}
