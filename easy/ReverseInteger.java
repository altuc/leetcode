public class Solution1 {
    public int reverse(int x) {
        String s = Integer.toString(x);
        try {
            StringBuffer sb = new StringBuffer();
            if(s.charAt(0) == '-') {
                sb.append(s.charAt(0));
                for(int i = s.length() - 1; i > 0; i--) {
                    sb.append(s.charAt(i));
                }
            } else {
                for(int i = s.length() - 1; i >= 0; i--) {
                    sb.append(s.charAt(i));
                }
            }
            s = sb.toString();
            return Integer.parseInt(s);
        } catch(NumberFormatException nfe) {
            return 0;
        }
    }
}

public class Solution2 {
    public int reverse(int x) {
        int res = 0;
        int upper = Integer.MAX_VALUE / 10;
        int y = x > 0 ? x : -x;
        while(y >= 1) {
            int temp = y % 10;
            y = y / 10;
            if(x > 0) {
                if(res > upper || (res == upper && temp > 7)) {
                    return 0;
                }
            } 
            if(x < 0) {
                if(res > upper || (res == upper && temp > 8)) {
                    return 0;
                }
            }
            res = 10 * res + temp;
        }
        return x > 0 ? res : -res; 
    }
}

public class Solution3 {
    public int reverse(int x) {
        long res = 0;
        int y = x > 0 ? x : -x;
        while(y >= 1) {
            int temp = y % 10;
            y = y / 10;
            if((10 * res + temp > Integer.MAX_VALUE && x > 0) || (-(10 * res + temp) < Integer.MIN_VALUE && x < 0)) {
                return 0;
            }
            res = 10 * res + temp;
        }
        return x > 0 ? (int)res : (int)-res; 
    }
}

public class Solution4 {
    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int temp = x % 10;
            if((res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < temp)) && x > 0) {
                return 0;
            }
            if((res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && Integer.MIN_VALUE % 10 > temp)) && x < 0) {
                return 0;
            }
            res = 10 * res + temp;
            x /= 10;
        }
        return res;
    }
}
