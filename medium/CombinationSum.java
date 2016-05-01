public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, res, list, 0);
        return res;
    }
    
    public void combinationSumHelper(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int start) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], res, list, i);
            list.remove(list.size() - 1);
        }
    }
}
