public class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        if(n == 2) {
            return "11";
        }
        String[] str = new String[n];
        str[0] = "1";
        str[1] = "11";
        for(int i = 2; i < str.length; i++) {
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