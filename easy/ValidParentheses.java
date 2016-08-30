public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> sta = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                sta.push(c);
            }
            if(c == ')' && (sta.empty() || sta.pop() != '(')) {
                return false;
            }
            if(c == '}' && (sta.empty() || sta.pop() != '{')) {
                return false;
            }
            if(c == ']' && (sta.empty() || sta.pop() != '[')) {
                return false;
            }
        }
        return sta.empty();
    }
}
