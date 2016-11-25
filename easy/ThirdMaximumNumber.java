public class Solution {
    public int thirdMax(int[] nums) {
        int first = nums[0];
        Integer second = null, third = null;
        int len = nums.length;
        for(int i = 1; i < len; i++) {
            if(nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if((second == null || nums[i] > second) && nums[i] < first) {
                third = second;
                second = nums[i];
            } else if((third == null || nums[i] > third) && second != null && nums[i] < second) {
                third = nums[i];
            }
        }
        return third == null ? first : third;
    }
}
