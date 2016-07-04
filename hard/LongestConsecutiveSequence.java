public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int res = 0;
        for(int n : nums) {
            set.add(n);
        }
        for(int n : nums) {
            int smaller = n - 1;
            int bigger = n + 1;
            int count = 1;
            while(set.contains(smaller)) {
                count++;
                set.remove(smaller);
                smaller--;
            }
            while(set.contains(bigger)) {
                count++;
                set.remove(bigger);
                bigger++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
