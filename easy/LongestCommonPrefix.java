public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        int len = strs.length;
        int end = strs[0].length();
        for(int i = 1; i < len; i++) {
            int strLen = strs[i].length();
            for(int j = 0; j < end; j++) {
                if(strLen == j || strs[i].charAt(j) != res.charAt(j)) {
                    end = j;
                    break;
                }
            }
        }
        return res.substring(0, end);
    }
}
