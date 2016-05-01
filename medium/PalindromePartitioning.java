public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return res;
        }
        partitionHelper(s, res, list, 0);
        return res;
    }
    
    public void partitionHelper(String s, List<List<String>> res, List<String> list, int start) {
        if(start == s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i = start; i < s.length(); i++) {
            if(!isPalindrome(s, start, i)) {
                continue;
            }
            list.add(s.substring(start, i + 1));
            partitionHelper(s, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
