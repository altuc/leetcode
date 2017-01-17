// O(nlogn)
public class Solution1 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0, len = nums.length;
        int[] lens = new int[len];
        for(int num : nums) {
            int start = 0, end = size;
            while(start < end) {
                int mid = start + (end - start) / 2;
                if(lens[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            lens[start] = num;
            if(start == size) {
                size += 1;
            }
        }
        return size;
    }
}

// O(n2)
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1, len = nums.length;
        int[] lens = new int[len];
        Arrays.fill(lens, 1);
        for(int i = 1; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    lens[i] = Math.max(lens[i], lens[j] + 1);
                }
            }
            max = Math.max(max, lens[i]);
        }
        return max;
    }
}
