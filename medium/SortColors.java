public class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                red++;
            }
            if(nums[i] == 1) {
                white++;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(i < red) {
                nums[i] = 0;
            }
            if(i >= red && i < white + red) {
                nums[i] = 1;
            }
            if(i >= white + red) {
                nums[i] = 2;
            }
        }
    }
}
