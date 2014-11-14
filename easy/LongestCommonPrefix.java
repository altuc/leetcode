public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int end = strs[0].length();
        for(int i = 1; i < strs.length; i++) {
            for(int j = 0; j < end; j++) {
                if(strs[i].length() == j || strs[i].charAt(j) != prefix.charAt(j)) {
                    end = j;
                    break;
                }
            }
        }
        return prefix.substring(0, end);
    }
}