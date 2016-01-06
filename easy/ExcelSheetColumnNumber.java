public class Solution {
    public int titleToNumber(String s) {
        int total = 0;
        for(int i = 0; i < s.length(); i++) {
            total = total * 26 + s.charAt(i) - 64;
        }
        return total;
    }
}
