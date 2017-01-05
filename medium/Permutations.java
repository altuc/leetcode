public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        permuteHelper(nums, res, list);
        return res;
    }
    
    private void permuteHelper(int[] nums, List<List<Integer>> res, List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permuteHelper(nums, res, list);
            list.remove(list.size() - 1);
        }
    }
}
