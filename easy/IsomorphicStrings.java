public class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        if(s.isEmpty() && t.isEmpty()) {
            return true;
        }
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }
    
    public boolean isIsomorphicHelper(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if(t.charAt(i) != map.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        if(s.isEmpty() && t.isEmpty()) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                if(map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if(t.charAt(i) != map.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
