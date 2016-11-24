public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strings) {
            int len = str.length();
            String key = "";
            for(int i = 1; i < len; i++) {
                int diff = str.charAt(i) - str.charAt(i - 1) < 0 ? str.charAt(i) - str.charAt(i - 1) + 26: str.charAt(i) - str.charAt(i - 1);
                key += diff;
            }
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for(List<String> group : map.values()) {
            Collections.sort(group);
            res.add(group);
        }
        return res;
    }
}
