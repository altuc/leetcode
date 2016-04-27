public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        subsetsHelper(nums, res, list);
        return res;
    }
    
    public void subsetsHelper(int[] nums, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<Integer>(list));
        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]) || (!list.isEmpty() && list.get(list.size() - 1) > nums[i])) {
                continue;
            }
            list.add(nums[i]);
            subsetsHelper(nums, res, list);
            list.remove(list.size() - 1);
        }
    }
}
