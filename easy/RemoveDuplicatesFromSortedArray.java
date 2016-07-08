public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}
