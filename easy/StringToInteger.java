public class Solution {
    public int myAtoi(String str) {
        int res = 0, sign = 1, pos = 0;
        if(str == null || str.trim().isEmpty()) {
            return res;
        }
        str = str.trim();
        int len = str.length();
        char first = str.charAt(0);
        if(first == '+') {
            pos++;
        }
        if(first == '-') {
            sign = -1;
            pos++;
        }
        while(pos < len) {
            if(str.charAt(pos) < '0' || str.charAt(pos) > '9') {
                break;
            }
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < str.charAt(pos) - '0')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + str.charAt(pos) - '0';
            pos++;
        }
        return sign * res;
    }
}
