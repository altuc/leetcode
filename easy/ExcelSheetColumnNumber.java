public class Solution {
    public int titleToNumber(String s) {
        int res = 0, len = s.length();
        for(int i = 0; i < len; i++) {
            res = 26 * res + s.charAt(i) - 'A' + 1;
        }
        return res;
    }
}
