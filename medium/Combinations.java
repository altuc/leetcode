public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(n < k || n < 1 || k < 1) {
            return res;
        }
        combineHelper(n, k, res, list, 1);
        return res;
    }
    
    public void combineHelper(int n, int k, List<List<Integer>> res, List<Integer> list, int start) {
        if(k == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i <= n; i++) {
            list.add(i);
            combineHelper(n, k - 1, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
