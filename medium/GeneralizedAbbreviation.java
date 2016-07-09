public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if(word == null) {
            return res;
        }
        generateAbbreviationsHelper(word, res, "", 0, 0);
        return res;
    }
    
    public void generateAbbreviationsHelper(String word, List<String> res, String cur, int pos, int count) {
        if(pos == word.length()) {
            cur = count > 0 ? cur + count : cur;
            res.add(cur);
            return;
        }
        generateAbbreviationsHelper(word, res, cur, pos + 1, count + 1);
        generateAbbreviationsHelper(word, res, cur + (count > 0 ? count : "") + word.charAt(pos), pos + 1, 0);
    }
}
