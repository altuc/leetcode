public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        int len = haystack.length() - needle.length();
        int needleLen = needle.length();
        for(int i = 0; i <= len; i++) {
            int j = 0;
            while(j < needleLen) {
                if(haystack.charAt(j + i) != needle.charAt(j)) {
                    break;
                }
                j++;
            }
            if(j == needleLen) {
                return i;
            }
        }
        return -1;
    }
}
