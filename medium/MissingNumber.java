// Sum
public class Solution1 {
    public int missingNumber(int[] nums) {
        int res = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            res += i;
            res -= nums[i];
        }
        res += n;
        return res;
    }
}

// XOR
public class Solution2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = n;
        for(int i = 0; i < n; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}

// Binary search
public class Solution3 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] <= mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
