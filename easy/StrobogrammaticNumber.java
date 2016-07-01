public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.isEmpty()) {
            return false;
        }
        int start = 0;
        int end = num.length() - 1;
        while(start < end) {
            if(num.charAt(start) == '6' && num.charAt(end) != '9') {
                return false;
            }
            if(num.charAt(start) == '9' && num.charAt(end) != '6') {
                return false;
            }
            if(num.charAt(start) == '8' && num.charAt(end) != '8') {
                return false;
            }
            if(num.charAt(start) == '1' && num.charAt(end) != '1') {
                return false;
            }
            if(num.charAt(start) == '0' && num.charAt(end) != '0') {
                return false;
            }
            if(num.charAt(start) == '2' || num.charAt(start) == '3' || num.charAt(start) == '4' || num.charAt(start) == '5' || num.charAt(start) == '7') {
                return false;
            }
            start++;
            end--;
        }
        if(start == end && num.charAt(start) != '0' && num.charAt(start) != '1' && num.charAt(start) != '8') {
            return false;
        }
        return true;
    }
}
