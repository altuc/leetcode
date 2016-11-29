public class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<Character>();
        for(char c : s.toCharArray()) {
            if(!set.add(c)) {
                set.remove(c);
            }
        }
        return set.isEmpty() ? s.length() : s.length() - set.size() + 1;
    }
}
