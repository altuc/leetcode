public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length < 3) {
            return;
        }
        int start = 0, end = s.length;
        reverse(s, 0, end - 1);
        for(int i = 0; i <= end; i++) {
            if(i == end || s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
    }
    
    private void reverse(char[] s, int i, int j) {
        while(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
