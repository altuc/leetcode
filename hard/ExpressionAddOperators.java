public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num == null || num.isEmpty()) {
            return res;
        }
        addOperatorsHelper(res, "", num, target, 0, 0, 0);
        return res;
    }
    
    public void addOperatorsHelper(List<String> res, String str, String num, int target, int start, long eval, long mult) {
        if(start == num.length()) {
            if(eval == target) {
                res.add(str);
            }
            return;
        }
        for(int i = start; i < num.length(); i++) {
            if(i != start && num.charAt(start) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(start, i + 1));
            if(start == 0) {
                addOperatorsHelper(res, str + cur, num, target, i + 1, cur, cur);
            } else {
                addOperatorsHelper(res, str + "+" + cur, num, target, i + 1, eval + cur, +cur);
                addOperatorsHelper(res, str + "-" + cur, num, target, i + 1, eval - cur, -cur);
                addOperatorsHelper(res, str + "*" + cur, num, target, i + 1, eval - mult + mult * cur, mult * cur);
            }
        }
    }
}
