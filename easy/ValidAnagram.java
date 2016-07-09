public class Solution1 {
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
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for(char c : t.toCharArray()) {
            if(!map.containsKey(c)) {
                return false;
            } else {
                if(map.get(c) == 0) {
                    return false;
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return true;
    }
}

public class Solution2 {
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
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for(int i = 0; i < sc.length; i++) {
            if(sc[i] != tc[i]) {
                return false;
            }
        }
        return true;
    }
}
