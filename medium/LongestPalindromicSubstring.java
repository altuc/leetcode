public class Solution {
    
    private int start = 0;
    private int max = 0;
    
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        for(int i = 0; i < s.length() - 1; i++) {
            longestPalindromeHelper(s, i, i);
            longestPalindromeHelper(s, i, i + 1);
        }
        return s.substring(start, start + max);
    }
    
    public void longestPalindromeHelper(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if(max < j - i - 1) {
            start = i + 1;
            max = j - i - 1;
        }
    }
}
