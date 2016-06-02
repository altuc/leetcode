public class Solution1 {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) {
            return true;
        }
        String ss = s.toLowerCase();
        Stack<Character> sta = new Stack<Character>();
        for(char c : ss.toCharArray()) {
            if((c <= 'z' && c >= 'a') || (c <= '9' && c >= '0')) {
                sta.push(c);
            }
        }
        for(char c : ss.toCharArray()) {
            if((c <= 'z' && c >= 'a') || (c <= '9' && c >= '0')) {
                if(c != sta.pop()) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Solution2 {
    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }
        String str = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            char left = str.charAt(start);
            char right = str.charAt(end);
            if(((left >= 'a' && left <= 'z') || (left >= '0' && left <= '9')) && ((right >= 'a' && right <= 'z') || (right >= '0' && right <= '9'))) {
                if(left != right) {
                    return false;
                }
                start++;
                end--;
            } else if(!((left >= 'a' && left <= 'z') || (left >= '0' && left <= '9')) && ((right >= 'a' && right <= 'z') || (right >= '0' && right <= '9'))) {
                start++;
            } else if(((left >= 'a' && left <= 'z') || (left >= '0' && left <= '9')) && !((right >= 'a' && right <= 'z') || (right >= '0' && right <= '9'))) {
                end--;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}

public class Solution3 {
    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        String str = s.toLowerCase();
        while(start < end) {
            if(str.charAt(start) < '0' || (str.charAt(start) > '9' && str.charAt(start) < 'a') || str.charAt(start) > 'z') {
                start++;
            } else if(str.charAt(end) < '0' || (str.charAt(end) > '9' && str.charAt(end) < 'a') || str.charAt(end) > 'z') {
                end--;
            } else {
                if(str.charAt(start) != str.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
