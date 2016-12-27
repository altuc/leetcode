public class Solution {
    private int start = 0;
    private int max = 1;
    
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length() - 1;
        for(int i = 0; i < len; i++) {
            longestPalindromeHelper(s, i, i);
            longestPalindromeHelper(s, i, i + 1);
        }
        return s.substring(start, start + max);
    }
    
    private void longestPalindromeHelper(String s, int i, int j) {
        int len = s.length();
        while(i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if(max < j - i - 1) {
            start = i + 1;
            max = j - i - 1;
        }
    }
}
