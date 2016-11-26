public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.trim().length() <= 1) {
            return s;
        }
        String vowels = "aeiouAEIOU";
        int start = 0, end = s.length() - 1;
        char[] arr = s.toCharArray();
        while(start < end) {
            while(start < end && vowels.indexOf(s.charAt(start)) == -1) {
                start++;
            }
            while(start < end && vowels.indexOf(s.charAt(end)) == -1) {
                end--;
            }
            if(start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        return new String(arr);
    }
}
