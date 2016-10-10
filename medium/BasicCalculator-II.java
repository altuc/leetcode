public class Solution {
    public int calculate(String s) {
        int number = 0;
        int res = 0;
        int addSign = 1;
        int multSign = 1;
        int temp = -1;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                number = 10 * number + c - '0';
            }
            if(c == '+') {
                if(temp >= 0) {
                    number = multSign == 1 ? temp * number : temp / number;
                }
                res += addSign * number;
                number = 0;
                temp = -1;
                addSign = 1;
            }
            if(c == '-') {
                if(temp >= 0) {
                    number = multSign == 1 ? temp * number : temp / number;
                }
                res += addSign * number;
                number = 0;
                temp = -1;
                addSign = -1;
            }
            if(c == '*') {
                if(temp < 0) {
                    temp = number;
                } else {
                    temp = multSign == 1 ? temp * number : temp / number;
                }
                number = 0;
                multSign = 1;
            }
            if(c == '/') {
                if(temp < 0) {
                    temp = number;
                } else {
                    temp = multSign == 1 ? temp * number : temp / number;
                }
                number = 0;
                multSign = -1;
            }
        }
        if(temp >= 0) {
            number = multSign == 1 ? temp * number : temp / number;
        } 
        res += addSign * number;
        return res;
    }
}
