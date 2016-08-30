public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.trim().isEmpty()) {
            return true;
        }
        s = s.trim().toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) < '0' || (s.charAt(left) > '9' && s.charAt(left) < 'a') || s.charAt(left) > 'z') {
                left++;
            } else if(s.charAt(right) < '0' || (s.charAt(right) > '9' && s.charAt(right) < 'a') || s.charAt(right) > 'z') {
                right--;
            } else {
                if(s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
