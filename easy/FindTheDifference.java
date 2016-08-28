public class Solution1 {
    public char findTheDifference(String s, String t) {
        char res = t.charAt(t.length() - 1);
        for(int i = 0; i < s.length(); i++) {
            res += t.charAt(i);
            res -= s.charAt(i);
        }
        return res;
    }
}

public class Solution2 {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for(char c : s.toCharArray()) {
            res ^= c;
        }
        for(char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
}
