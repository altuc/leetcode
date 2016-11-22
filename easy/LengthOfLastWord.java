public class Solution1 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.trim().isEmpty()) {
            return 0;
        }
        s = s.trim();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                return s.length() - i - 1;
            }
        }
        return s.length();
    }
}

public class Solution2 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.trim().isEmpty()) {
            return 0;
        }
        String[] strs = s.trim().split(" ");
        return strs[strs.length - 1].length();
    }
}
