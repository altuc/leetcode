public class Solution1 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int res = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                res = i;
            }
        }
        return res;
    }
}

public class Solution2 {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
