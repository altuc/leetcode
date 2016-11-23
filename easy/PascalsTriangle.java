public class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows <= 0) {
            return res;
        }
        List<Integer> cur = new ArrayList<Integer>();
        List<Integer> pre = new ArrayList<Integer>();
        cur.add(1);
        res.add(cur);
        for(int i = 1; i < numRows; i++) {
            pre = cur;
            cur = new ArrayList<Integer>();
            cur.add(1);
            for(int j = 1; j < i; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}

public class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if(numRows <= 0) {
            return rs;
        }
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(1);
        rs.add(ls);
        return generateHelper(numRows, rs, ls);
    }
    
    private List<List<Integer>> generateHelper(int numRows, List<List<Integer>> rs, List<Integer> ls) {
        if(numRows == 1) {
            return rs;
        }
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        int size = ls.size();
        for(int i = 1; i < size; i++) {
            row.add(ls.get(i - 1) + ls.get(i));
        }
        row.add(1);
        rs.add(row);
        numRows--;
        return generateHelper(numRows, rs, row);
    }
}
