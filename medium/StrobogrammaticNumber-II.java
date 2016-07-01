public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<String>();
        if(n <= 0) {
            return res;
        }
        findStrobogrammaticHelper(res, "", "", 0, n - 1);
        return res;
    }
    
    public void findStrobogrammaticHelper(List<String> res, String firstHalf, String secondHalf, int start, int end) {
        if(start > end) {
            res.add(firstHalf + secondHalf);
            return;
        } else if(start == end) {
            res.add(firstHalf + "0" + secondHalf);
            res.add(firstHalf + "1" + secondHalf);
            res.add(firstHalf + "8" + secondHalf);
            return;
        } else {
            if(start != 0) {
                findStrobogrammaticHelper(res, firstHalf + "0", "0" + secondHalf, start + 1, end - 1);
            }
            findStrobogrammaticHelper(res, firstHalf + "1", "1" + secondHalf, start + 1, end - 1);
            findStrobogrammaticHelper(res, firstHalf + "8", "8" + secondHalf, start + 1, end - 1);
            findStrobogrammaticHelper(res, firstHalf + "6", "9" + secondHalf, start + 1, end - 1);
            findStrobogrammaticHelper(res, firstHalf + "9", "6" + secondHalf, start + 1, end - 1);
        }
    }
}
