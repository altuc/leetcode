public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUniqueHelper(nums, res, list, visited);
        return res;
    }
    
    private void permuteUniqueHelper(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if((i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) || visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            permuteUniqueHelper(nums, res, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
