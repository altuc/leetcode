public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i >= 0) {
            int j = nums.length - 1;
            while(nums[i] >= nums[j]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int start = i + 1;
        int end = nums.length - 1;
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
