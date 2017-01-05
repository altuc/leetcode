public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        int[] res = new int[len];
        res[0] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 1; i < len; i++) {
            int num = Integer.parseInt(s.substring(i - 1, i + 1));
            if(num >= 10 && num <= 26) {
                res[i] = i == 1 ? 1 : res[i - 2];
            }
            if(s.charAt(i) != '0') {
                res[i] += res[i - 1];
            }
        }
        return res[len - 1];
    }
}
