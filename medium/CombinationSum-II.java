public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, res, list, 0);
        return res;
    }
    
    public void combinationSum2Helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int start) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if(target - candidates[i] < 0) {
                return;
            }
            list.add(candidates[i]);
            combinationSum2Helper(candidates, target - candidates[i], res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
