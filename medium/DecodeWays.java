public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        if(s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        int n = s.length();
        int[] res = new int[n];
        res[0] = s.charAt(0) == '0' ? 0 : 1;
        if(s.charAt(0) != '0' && s.charAt(1) != '0') {
            res[1] += 1;
        }
        if(Integer.parseInt(s.substring(0, 2)) >= 10 && Integer.parseInt(s.substring(0, 2)) <= 26) {
            res[1] += 1;
        }
        for(int i = 2; i < n; i++) {
            int first = Integer.parseInt(s.substring(i, i + 1));
            int second = Integer.parseInt(s.substring(i - 1, i + 1));
            if(first >= 1 && first <= 9) {
                res[i] += res[i - 1];
            }
            if(second >= 10 && second <= 26) {
                res[i] += res[i - 2];
            }
        }
        return res[n - 1];
    }
}
