public class Solution1 {
    public int findPeakElement(int[] nums) {
        int end = nums.length - 1;
        for(int i = 1; i <= end; i++) {
            if(nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }
        return end;
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
