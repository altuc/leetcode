public class Solution1 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(rowIndex < 0) {
            return res;
        } else {
            ArrayList<Integer> toplevel = new ArrayList<Integer>();
            toplevel.add(1);
            res = toplevel;
            if(rowIndex > 0) {
                int n = 1;
                ArrayList<Integer> uplevel = toplevel;
                while(n <= rowIndex) {
                    ArrayList<Integer> level = new ArrayList<Integer>();
                    level.add(1);
                    for(int i = 1; i < n; i++) {
                        level.add(uplevel.get(i-1) + uplevel.get(i));
                    }
                    level.add(1);
                    res = level;
                    uplevel = level;
                    n++;
                }
            }
            return res;
        }
    }
}

public class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ls = new ArrayList<Integer>();
        ls.add(1);
        return getRowHelper(rowIndex, ls);
    }
    
    public List<Integer> getRowHelper(int rowIndex, ArrayList<Integer> ls) {
        if(rowIndex == 0) {
            return ls;
        }
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        if(ls.size() > 1) {
            for(int i = 0; i < ls.size()-1; i++) {
                row.add(ls.get(i) + ls.get(i+1));
            }
        }
        row.add(1);
        rowIndex--;
        return getRowHelper(rowIndex, row);
    }
}

public class Solution3 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if(rowIndex < 0) {
            return res;
        }
        res.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for(int j = 1; j < res.size(); j++) {
                int num = res.get(j - 1) + res.get(j);
                row.add(num);
            }
            row.add(1);
            res = row;
        }
        return res;
    }
}
