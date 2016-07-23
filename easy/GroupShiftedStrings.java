public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0) {
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strings) {
            String index = "";
            for(int i = 1; i < s.length(); i++) {
                int diff = s.charAt(i) - s.charAt(i - 1) >= 0 ? s.charAt(i) - s.charAt(i - 1) : s.charAt(i) - s.charAt(i - 1) + 26;
                index += String.valueOf(diff);
            }
            if(!map.containsKey(index)) {
                map.put(index, new ArrayList<String>());
            }
            map.get(index).add(s);
        }
        for(List<String> ls : map.values()) {
            Collections.sort(ls);
            res.add(ls);
        }
        return res;
    }
}
