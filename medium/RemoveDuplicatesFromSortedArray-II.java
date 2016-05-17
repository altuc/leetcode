public class Solution1 {
    public int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if(nums.length < 3) {
            return nums.length;
        }
        Arrays.sort(nums);
        int length = 1;
        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                if(count == 0) {
                    count++;
                    length++;
                }
            } else {
                count = 0;
                length++;
            }
            nums[length - 1] = nums[i];
        }
        return length;
    }
}

public class Solution2 {
    public int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if(nums.length < 3) {
            return nums.length;
        }
        Arrays.sort(nums);
        int i = 0;
        for(int n : nums) {
            if(i < 2 || n > nums[i - 2]) {
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}
