public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }
        Deque<Character> sta = new ArrayDeque<Character>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                sta.push(c);
            }
            if(c == ')' && (sta.isEmpty() || sta.pop() != '(')) {
                return false;
            }
            if(c == '}' && (sta.isEmpty() || sta.pop() != '{')) {
                return false;
            }
            if(c == ']' && (sta.isEmpty() || sta.pop() != '[')) {
                return false;
            }
        }
        return sta.isEmpty();
    }
}
