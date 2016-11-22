public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int pos = 1;
        int len = nums.length;
        for(int i = 1; i < len; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}
