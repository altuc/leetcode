public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for(int n : nums) {
            if(n <= i) {
                i = n;
            } else if(n <= j) {
                j = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
