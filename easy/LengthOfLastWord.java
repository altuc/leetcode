/* characters are only alphabetical in last word */
public class Solution1 {
    public int lengthOfLastWord(String s) {
        String str = s.toLowerCase().trim();
        if(str.isEmpty() || s == null) {
            return 0;
        }
        String[] strs = str.split(" ");
        for(char c : strs[strs.length - 1].toCharArray()) {
            if(c > 'z' || c < 'a') {
                return 0;
            }
        }
        return strs[strs.length - 1].length();
    }
}

/* characters are not only alphabetical in last word */
public class Solution2 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int end = s.length() - 1;
        int count = 0;
        for (int i = end; i > -1; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            }
            if (s.charAt(i) == ' ' && count != 0) {
                return count;
            }
        }
        return count;
    }
}

public class Solution3 {
    public int lengthOfLastWord(String s) {
        if(s.isEmpty() || s == null) {
            return 0;
        }
        String[] str = s.trim().split(" ");
        if(str.length == 0) {
            return 0;
        } else {
            return str[str.length - 1].length();
        }
    }
}
