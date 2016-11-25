public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.trim().split(" ");
        int len = pattern.length();
        if(len != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            if(!map.containsKey(pattern.charAt(i))) {
                if(map.containsValue(words[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), words[i]);
            } else {
                if(!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
