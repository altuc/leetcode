public class Solution1 {
    public int findPeakElement(int[] nums) {
        int res = 0, len = nums.length;
        for(int i = 1; i < len; i++) {
            if(nums[i] > nums[i - 1]) {
                res = i;
            }
        }
        return res;
    }
}

public class Solution2 {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
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
