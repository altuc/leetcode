public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 10) {
            return res;
        }
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if(!set.add(str) && !res.contains(str)) {
                res.add(str);
            }
        }
        return res;
    }
}
