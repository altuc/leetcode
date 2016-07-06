public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) {
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

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int len = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                left = left <= map.get(s.charAt(i)) ? map.get(s.charAt(i)) + 1 : left;
            } 
            map.put(s.charAt(i), i);
            len = Math.max(len, i - left + 1);
        }
        return len;
    }
}
