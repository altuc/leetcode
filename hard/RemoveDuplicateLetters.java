public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.isEmpty()) {
            return s;
        }
        int[] count = new int[26];
        int pos = 0;
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            count[s.charAt(i) - 'a']--;
            if(count[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}
