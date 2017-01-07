public class Solution1 {
    public String reverseWords(String s) {
        if(s == null || s.isEmpty()) {
            return s;
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) {
            if(!strs[i].equals("")) {
                sb.append(strs[i].trim() + " ");
            }
        }
        return sb.toString().trim();
    }
}

public class Solution2 {
    public String reverseWords(String s) {
        if(s == null) {
            return s;
        }
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int j = s.length();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(i < s.length() - 1 && s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
                sb.append(s.substring(i + 1, j) + " ");
            }
            if(i >= 1 && s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
                j = i;
            }
        }
        sb.append(s.substring(0, j));
        return sb.toString();
    }
}
