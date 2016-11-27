public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word.length() < abbr.length()) {
            return false;
        }
        int wLen = word.length(), aLen = abbr.length(), i = 0, j = 0;
        while(i < wLen && j < aLen) {
            if(word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else if(abbr.charAt(j) == '0' || abbr.charAt(j) > '9') {
                return false;
            } else {
                int k = j;
                while(j < aLen && abbr.charAt(j) < 'a') {
                    j++;
                }
                int gap = Integer.parseInt(abbr.substring(k, j));
                i += gap;
            }
        }
        return i == wLen && j == aLen;
    }
}
