public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        int left = 0, minLeft = 0, count = 0, len = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if(map.get(s.charAt(i)) >= 0) {
                    count++;
                }
            }
            while(count == t.length()) {
                if(i - left + 1 < len) {
                    minLeft = left;
                    len = i - left + 1;
                }
                if(map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + len);
    }
}
