public class Solution1 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int res = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                res = i;
            }
        }
        return res;
    }
}
