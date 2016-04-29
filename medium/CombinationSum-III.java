public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(n < 1 || n > 45 || k < 1 || k > 9 || k >= n) {
            return res;
        }
        combinationSum3Helper(k, n, res, list, 1);
        return res;
    }
    
    public void combinationSum3Helper(int k, int n, List<List<Integer>> res, List<Integer> list, int start) {
        if(k == 0 && n == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        } else if((k == 0 && n != 0) || (k != 0 && n <= 0)) {
            return;
        } else {
            for(int i = start; i <= 9; i++) {
                list.add(i);
                combinationSum3Helper(k - 1, n - i, res, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
