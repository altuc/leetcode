public class Solution1 {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int end = 0;
        while(end < nums.length) {
            if(nums[end] == 0) {
                end++;
            } else {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end++;
            }
        }
    }
}

public class Solution2 {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return;
        int tail = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[tail++] = nums[i];
            }
        }
        while(tail < nums.length) {
            nums[tail++] = 0;
        }
    }
}
