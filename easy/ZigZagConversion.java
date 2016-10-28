public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() <= numRows || numRows == 1) {
            return s;
        }
        int len = s.length();
        int unit = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < len; j += unit) {
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows - 1 && j + unit - 2 * i < len) {
                    sb.append(s.charAt(j + unit - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}
