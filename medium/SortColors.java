public class Solution1 {
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

public class Solution2 {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int i = 0; i <= end; i++) {
            if(nums[i] == 0) {
                if(i != start) {
                    nums[i] = nums[start];
                    nums[start] = 0;
                }
                start++;
            }
            if(nums[i] == 2) {
                if(i != end) {
                    nums[i] = nums[end];
                    nums[end] = 2;
                }
                end--;
                i--;
            }
        }
    }
}
