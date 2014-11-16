public class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()) {
            return true;
        }
        if(s.length() == 1) {
            return false;
        }
        Stack<Character> sta = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(sta.empty()) {
                sta.push(c);
            } else {
                if((c == ')' && sta.peek() == '(') || (c == '}' && sta.peek() == '{') || (c == ']' && sta.peek() == '[')) {
                    sta.pop();
                } else {
                    sta.push(c);
                }
            }
        }
        return sta.size() == 0;
    }
}