public class Solution1 {
    public String countAndSay(int n) {
        String[] str = new String[n];
        str[0] = "1";
        for(int i = 1; i < str.length; i++) {
            str[i] = "";
            int count = 1;
            for(int j = 0; j < str[i-1].length() - 1; j++) {
                if(str[i-1].charAt(j) == str[i-1].charAt(j+1)) {
                    count++;
                } else {
                    str[i] = str[i] + Integer.toString(count) + Character.toString(str[i-1].charAt(j));
                    count = 1;
                }
            }
            str[i] = str[i] + Integer.toString(count) + Character.toString(str[i-1].charAt(str[i-1].length() - 1));
        }
        return str[n-1];
    }
}

public class Solution2 {
    public String countAndSay(int n) {
        String cur = "1";
        while(n > 1) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < cur.length(); i++) {
                int count = 1;
                while((i+1) < cur.length() && cur.charAt(i) == cur.charAt(i+1)) {
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
