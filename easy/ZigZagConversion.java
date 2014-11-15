public class Solution {
    public String convert(String s, int nRows) {
        if(nRows <= 1 || s.length() <= nRows) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int unit = 2 * nRows - 2;
        for(int i = 0; i < nRows; i++) {
            for(int j = i; j < s.length(); j = j + unit) {
                sb.append(s.charAt(j));
                if(i != 0 && i != nRows - 1 && j + unit - 2 * i < s.length()) {
                    sb.append(s.charAt(j + unit - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}