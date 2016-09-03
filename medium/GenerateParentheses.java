public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n <= 0) {
            return res;
        }
        generateParenthesisHelper(res, "", n, n);
        return res;
    }
    
    public void generateParenthesisHelper(List<String> res, String current, int left, int right) {
        if(left > right || left < 0) {
            return;
        }
        if(left == 0 && right == 0) {
            res.add(current);
            return;
        }
        generateParenthesisHelper(res, current + "(", left - 1, right);
        generateParenthesisHelper(res, current + ")", left, right - 1);
    }
}
