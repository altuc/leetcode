public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.isEmpty()) {
            return res;
        }
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        String combination = "";
        int start = 0;
        letterCombinationsHelper(digits, res, combination, start, mapping);
        return res;
    }
    
    public void letterCombinationsHelper(String digits, List<String> res, String combination, int start, String[] mapping) {
        if(combination.length() == digits.length()) {
            res.add(combination);
            return;
        }
        String letters = mapping[digits.charAt(start) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            letterCombinationsHelper(digits, res, combination + letters.charAt(i), start + 1, mapping);
        }
    }
}
