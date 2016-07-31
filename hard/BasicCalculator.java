public class Solution {
    public int calculate(String s) {
        Stack<Integer> sta = new Stack<Integer>();
        int number = 0;
        int res = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                number = 10 * number + (c - '0');
            }
            if(c == '+') {
                res += sign * number;
                number = 0;
                sign = 1;
            }    
            if(c == '-') {
                res += sign * number;
                number = 0;
                sign = -1;
            }   
            if(c == '(') {
                sta.push(res);
                sta.push(sign);
                sign = 1;
                res = 0;
            }
            if(c == ')') {
                res += sign * number;
                number = 0;
                res *= sta.pop();
                res += sta.pop();
            }
        }
        if(number != 0) {
            res += sign * number;
        }
        return res;
    }
}
