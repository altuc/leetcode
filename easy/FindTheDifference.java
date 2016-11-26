public class Solution1 {
    public char findTheDifference(String s, String t) {
        char res = t.charAt(t.length() - 1);
        for(int i = s.length() - 1; i >= 0; i--) {
            res += t.charAt(i);
            res -= s.charAt(i);
        }
        return res;
    }
}

public class Solution2 {
    public char findTheDifference(String s, String t) {
        char res = t.charAt(t.length() - 1);
        for(int i = s.length() - 1; i >= 0; i--) {
            res ^= t.charAt(i);
            res ^= s.charAt(i);
        }
        return res;
    }
}
