public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] notFound = new int[]{-1, -1};
        int[] range = new int[2];
        if(nums == null || nums.length == 0) {
            return notFound;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if(target == nums[start]) {
            range[0] = start;
        } else {
            return notFound;
        }
        end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2 + 1;
            if(target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        range[1] = end;
        return range;
    }
}
