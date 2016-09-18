public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<String>();
        int rmLeft = 0;
        int rmRight = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                rmLeft++;
            } 
            if(c == ')') {
                if(rmLeft > 0) {
                    rmLeft--;
                } else {
                    rmRight++;
                }
            }
        }
        removeInvalidParenthesesHelper(s, res, 0, rmLeft, rmRight, 0, "");
        return new ArrayList<String>(res);
    }
    
    public void removeInvalidParenthesesHelper(String s, Set<String> res, int start, int rmLeft, int rmRight, int open, String str) {
        if(start == s.length() && rmLeft == 0 && rmRight == 0 && open == 0) {
            res.add(str);
            return;
        }
        if(start == s.length() || rmLeft < 0 || rmRight < 0 || open < 0) {
            return;
        }
        char c = s.charAt(start);
        if(c == '(') {
            removeInvalidParenthesesHelper(s, res, start + 1, rmLeft - 1, rmRight, open, str);
            removeInvalidParenthesesHelper(s, res, start + 1, rmLeft, rmRight, open + 1, str + c);
        } else if(c == ')') {
            removeInvalidParenthesesHelper(s, res, start + 1, rmLeft, rmRight - 1, open, str);
            removeInvalidParenthesesHelper(s, res, start + 1, rmLeft, rmRight, open - 1, str + c);
        } else {
            removeInvalidParenthesesHelper(s, res, start + 1, rmLeft, rmRight, open, str + c);
        }
    }
}
