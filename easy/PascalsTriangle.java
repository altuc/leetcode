public class Solution1 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows <= 0) {
            return res;
        } else {
            ArrayList<Integer> toplevel = new ArrayList<Integer>();
            toplevel.add(1);
            res.add(toplevel);
            if(numRows > 1) {
                int n = 1;
                ArrayList<Integer> uplevel = toplevel;
                while(n < numRows) {
                    ArrayList<Integer> level = new ArrayList<Integer>();
                    level.add(1);
                    for(int i = 1; i < n; i++) {
                        level.add(uplevel.get(i-1) + uplevel.get(i));
                    }
                    level.add(1);
                    res.add(level);
                    uplevel = level;
                    n++;
                }
            }
            return res;
        }
    }
}

public class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> rs = new ArrayList<List<Integer>>();
        if(numRows == 0) {
            return rs;
        }
        ArrayList<Integer> ls = new ArrayList<Integer>();
        ls.add(1);
        rs.add(ls);
        return generateHelper(numRows, rs, ls);
    }
    
    public List<List<Integer>> generateHelper(int numRows, ArrayList<List<Integer>> rs, ArrayList<Integer> ls) {
        if(numRows == 1) {
            return rs;
        }
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        if(ls.size() > 1) {
            for(int i = 0; i < ls.size()-1; i++) {
                row.add(ls.get(i) + ls.get(i+1));
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
