public class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows <= 0) {
            return res;
        }
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        res.add(pre);
        int level = 1;
        while(level < numRows) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for(int i = 1; i < level; i++) {
                row.add(pre.get(i - 1) + pre.get(i));
            }
            row.add(1);
            res.add(row);
            pre = row;
            level++;
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
    
    public List<List<Integer>> generateHelper(int numRows, List<List<Integer>> rs, List<Integer> ls) {
        if(numRows == 1) {
            return rs;
        }
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        if(ls.size() > 1) {
            for(int i = 0; i < ls.size() - 1; i++) {
                row.add(ls.get(i) + ls.get(i + 1));
            }
        }
        row.add(1);
        rs.add(row);
        numRows--;
        return generateHelper(numRows, rs, row);
    }
}

public class Solution3 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> firstRow = new ArrayList<Integer>();
        if(numRows <= 0) {
            return res;
        }
        firstRow.add(1);
        res.add(firstRow);
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for(int j = 1; j < res.get(i - 1).size(); j++) {
                int num = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                row.add(num);
            }
            row.add(1);
            res.add(row);
        }
        return res;   
    }
}
