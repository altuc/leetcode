public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length <= 2) {
            return;
        }
        reverse(s, 0, s.length - 1);
        int left = 0;
        for(int i = 0; i <= s.length; i++) {
            if(i == s.length || s[i] == ' ') {
                reverse(s, left, i - 1);
                left = i + 1;
            }
        }
    }
    
    public void reverse(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
