public class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
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

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> ls = new ArrayList<Integer>();
        subsetsHelper(nums, res, ls, 0);
        return res;
    }
    
    public void subsetsHelper(int[] nums, List<List<Integer>> res, List<Integer> ls, int start) {
        res.add(new ArrayList<Integer>(ls));
        for(int i = start; i < nums.length; i++) {
            ls.add(nums[i]);
            subsetsHelper(nums, res, ls, i + 1);
            ls.remove(ls.size() - 1);
        }
    }
}
