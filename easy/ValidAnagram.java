public class Solution1 {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        int len = s.length();
        for(int i = 0; i < len; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < len; i++) {
            if(arr[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            arr[t.charAt(i) - 'a']--;
        }
        return true;
    }
}

public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        int len = sc.length;
        for(int i = 0; i < len; i++) {
            if(sc[i] != tc[i]) {
                return false;
            }
        }
        return true;
    }
}
