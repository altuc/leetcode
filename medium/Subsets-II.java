public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, res, list, 0);
        return res;
    }
    
    public void subsetsWithDupHelper(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        res.add(new ArrayList<Integer>(list));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsWithDupHelper(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
