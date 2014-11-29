public class Solution {
    public String reverseWords(String s) {
        if(s.isEmpty()) {
            return "";
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