public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int temp = i;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] > nums[temp]) {
                    res[i]++;
                    temp = j;
                }
            }
        }
        for(int i = 0; i < res.length; i++) {
            if(res[i] >= 2) {
                return true;
            }
        }
        return false;
    }
}
