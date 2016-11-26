public class Solution1 {
    public int firstUniqChar(String s) {
        if(s == null || s.isEmpty()) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int index : map.values()) {
            if(index >= 0) {
                res = Math.min(res, index);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

public class Solution2 {
    public int firstUniqChar(String s) {
        if(s == null || s.isEmpty()) {
            return -1;
        }
        int[] count = new int[26];
        int len = s.length();
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for(int i = 0; i < len; i++) {
            if(count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
