public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == 0) {
                    List<Integer> ls = new ArrayList<Integer>();
                    ls.add(nums[i]);
                    ls.add(nums[start]);
                    ls.add(nums[end]);
                    res.add(ls);
                    start++;
                    end--;
                    while(start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while(start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if(sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}
