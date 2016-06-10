public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.trim().isEmpty()) {
            return s;
        }
        int start = 0;
        int end = s.length() - 1;
        char[] res = s.toCharArray();
        String vowels = "aeiouAEIOU";
        while(start < end) {
            if(vowels.indexOf(res[start]) != -1 && vowels.indexOf(res[end]) != -1) {
                char temp = res[start];
                res[start] = res[end];
                res[end] = temp;
                start++;
                end--;
            } else if(vowels.indexOf(res[start]) != -1) {
                end--;
            } else if(vowels.indexOf(res[end]) != -1) {
                start++;
            } else {
                start++;
                end--;
            }
        }
        return String.valueOf(res);
    }
}
