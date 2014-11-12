public class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) {
            return true;
        }
        String ss = s.toLowerCase();
        Stack<Character> sta = new Stack<Character>();
        for(char c : ss.toCharArray()) {
            if((c <= 'z' && c >= 'a') || (c <= '9' && c >= '0')) {
                sta.push(c);
            }
        }
        for(char c : ss.toCharArray()) {
            if((c <= 'z' && c >= 'a') || (c <= '9' && c >= '0')) {
                if(c != sta.pop()) {
                    return false;
                }
            }
        }
        return true;
    }
}