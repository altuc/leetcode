public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n <= 3) {
            return res;
        }
        List<Integer> ls = new ArrayList<Integer>();
        getFactorsHelper(n, res, ls, 2);
        return res;
    }
    
    public void getFactorsHelper(int n, List<List<Integer>> res, List<Integer> ls, int start) {
        for(int i = start; i <= (int) Math.sqrt(n); i++) {
            if(n % i == 0 && n / i >= i) {
                ls.add(i);
                ls.add(n / i);
                res.add(new ArrayList<Integer>(ls));
                ls.remove(ls.size() - 1);
                getFactorsHelper(n / i, res, ls, i);
                ls.remove(ls.size() - 1);
            }
        }
    }
}
