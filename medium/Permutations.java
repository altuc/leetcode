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
    
    public void permuteHelper(int[] nums, List<List<Integer>> res, List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permuteHelper(nums, res, list);
            list.remove(list.size() - 1);
        }
    }
}
