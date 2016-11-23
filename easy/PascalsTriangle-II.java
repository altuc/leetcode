public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            int pre = 1;
            for(int j = 1; j < i; j++) {
                int tmp = res.get(j);
                res.set(j, pre + res.get(j));
                pre = tmp;
            }
            res.add(1);
        }
        return res;
    }
}
