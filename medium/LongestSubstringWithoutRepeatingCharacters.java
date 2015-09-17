public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty() || s == null) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int length = 0;
        int pointer = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)) && pointer <= map.get(s.charAt(i))) {
                max = Math.max(max, length);
                pointer = map.get(s.charAt(i)) + 1;
                length = i - map.get(s.charAt(i));
            } else {
                length++;
            }
            map.put(s.charAt(i), i);
        }
        max = Math.max(max, length);
        return max;
    }
}