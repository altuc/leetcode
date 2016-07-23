public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if(word == null) {
            return res;
        }
        generateAbbreviationsHelper(word, res, "", 0, 0);
        return res;
    }
    
    public void generateAbbreviationsHelper(String word, List<String> res, String cur, int start, int count) {
        if(start == word.length()) {
            cur = count > 0 ? cur + count : cur;
            res.add(cur);
            return;
        }
        generateAbbreviationsHelper(word, res, cur, start + 1, count + 1);
        generateAbbreviationsHelper(word, res, cur + (count > 0 ? count : "") + word.charAt(start), start + 1, 0);
    }
}
