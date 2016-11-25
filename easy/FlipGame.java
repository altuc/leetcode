public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() < 2) {
            return res;
        }
        int len = s.length() - 1;
        for(int i = 0; i < len; i++) {
            if(s.substring(i, i + 2).equals("++")) {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return res;
    }
}
