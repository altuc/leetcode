public class Solution1 {
    public int atoi(String str) {
        long temp = 0;
        if(str.isEmpty()) {
            return 0;
        }
        String s = str.trim();
        if((s.charAt(0) < '0' || s.charAt(0) > '9') && s.charAt(0) != '-' && s.charAt(0) != '+') {
            return 0;
        }
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i) < '0' || s.charAt(i) > '9') {
                    s = s.substring(0, i);
                    break;
                }
                if(-(10 * temp + Integer.parseInt(String.valueOf(s.charAt(i)))) < Integer.MIN_VALUE && s.charAt(0) == '-') {
                    return -2147483648;
                }
                if(10 * temp + Integer.parseInt(String.valueOf(s.charAt(i))) > Integer.MAX_VALUE && s.charAt(0) == '+') {
                    return 2147483647;
                }
                temp = 10 * temp + Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        if(s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) < '0' || s.charAt(j) > '9') {
                    s = s.substring(0, j);
                    break;
                }
                if(10 * temp + Integer.parseInt(String.valueOf(s.charAt(j))) > Integer.MAX_VALUE) {
                    return 2147483647;
                }
                temp = 10 * temp + Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        if (s.equals("+") || s.equals("-")) {
	    return 0;
	}
        if(s.charAt(0) == '+' && s.length() > 1) {
            s = s.substring(1);
        }
        return Integer.parseInt(s);
    }
}

public class Solution2 {
    public int myAtoi(String str) {
        if(str == null || str.trim().isEmpty()) {
            return 0;
        }
        str = str.trim();
        int sign = 1, start = 0, res = 0, len = str.length();
        if(str.charAt(0) == '+') {
            sign = 1;
            start++;
        }
        if(str.charAt(0) == '-') {
            sign = -1;
            start++;
        }
        for(int i = start; i < len; i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < str.charAt(i) - '0')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else{
                res = 10 * res + str.charAt(i) - '0';
            }
        }
        return sign * res;
    }
}
