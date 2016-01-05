public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) {
            return true;
        }
        if((s == null && t != null) || (s != null && t == null)) {
            return false;
        }
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for(int j = 0; j < t.length(); j++) {
            if(map.containsKey(t.charAt(j))) {
                if(map.get(t.charAt(j)) == 0) {
                    return false;
                } else {
                    map.put(t.charAt(j), map.get(t.charAt(j)) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
