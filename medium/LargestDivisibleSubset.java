public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        int max = 1;
        Arrays.sort(nums);
        List<Integer>[] subsets = new ArrayList[nums.length];
        for(int i = 0; i < nums.length; i++) {
            subsets[i] = new ArrayList<Integer>();
            subsets[i].add(nums[i]);
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(subsets[j].size() + 1 > subsets[i].size()) {
                        subsets[i] = new ArrayList<Integer>();
                        subsets[i].addAll(subsets[j]);
                        subsets[i].add(nums[i]);
                    }
                }
            }
            if(subsets[i].size() >= max) {
                max = subsets[i].size();
                res = subsets[i];
            }
        }
        return res;
    }
}
