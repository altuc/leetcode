public class Solution1 {
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

public class Solution2 {
    public boolean isValid(String s) {
        if(s.isEmpty() || s == null) {
            return true;
        }
        if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}' || s.length() == 1) {
            return false;
        }
        Stack<Character> sta = new Stack<>();
        for(char c : s.toCharArray()) {
            if(sta.empty()) {
                sta.push(c);
            } else {
                if((c == ')' && sta.pop() != '(') || (c == ']' && sta.pop() != '[') || (c == '}' && sta.pop() != '{')) {
                    return false;
                } 
                if(c == '(' || c == '[' || c == '{') {
                    sta.push(c);
                }
            }
        }
        return sta.empty();
    }
}
