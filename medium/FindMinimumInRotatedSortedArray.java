// O(N)
public class Solution1 {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}

// Binary Search - O(logN)
public class Solution2 {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[end]) {
                end = mid;
            } else if(nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                return nums[mid];
            }
        }
        return nums[start];
    }
}
