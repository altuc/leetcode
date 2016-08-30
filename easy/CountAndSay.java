public class Solution1 {
    public String countAndSay(int n) {
        String[] str = new String[n];
        str[0] = "1";
        for(int i = 1; i < str.length; i++) {
            str[i] = "";
            int count = 1;
            for(int j = 0; j < str[i - 1].length() - 1; j++) {
                if(str[i - 1].charAt(j) == str[i - 1].charAt(j + 1)) {
                    count++;
                } else {
                    str[i] = str[i] + count + str[i - 1].charAt(j);
                    count = 1;
                }
            }
            str[i] = str[i] + count + str[i - 1].charAt(str[i - 1].length() - 1);
        }
        return str[n - 1];
    }
}

public class Solution2 {
    public String countAndSay(int n) {
        String cur = "1";
        while(n > 1) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < cur.length(); i++) {
                int count = 1;
                while((i + 1) < cur.length() && cur.charAt(i) == cur.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb = sb.append(Integer.toString(count)).append(Character.toString(cur.charAt(i)));
            }
            cur = sb.toString();
            n--;
        }
        return cur;
    }
}

public class Solution3 {
    public String countAndSay(int n) {
        if(n <= 0) {
            return "";
        }
        String str = "1";
        if(n == 1) {
            return str;
        }
        for(int i = 2; i <= n; i++) {
            String tmp = "";
            int count = 1;
            int j = 1;
            for(; j < str.length(); j++) {
                if(str.charAt(j - 1) != str.charAt(j)) {
                    tmp = tmp + Integer.toString(count) + String.valueOf(str.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            tmp = tmp + Integer.toString(count) + String.valueOf(str.charAt(j - 1));
            str = tmp;
        }
        return str;
    }
}
