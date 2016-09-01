public class Solution1 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() < 2) {
            return res;
        }
        char[] ca = s.toCharArray();
        for(int i = 1; i < s.length(); i++) {
            if(ca[i - 1] == '+' && ca[i] == '+') {
                ca[i] = '-';
                ca[i - 1] = '-';
                res.add(new String(ca));
                ca[i] = '+';
                ca[i - 1] = '+';
            }
        }
        return res;
    }
}

public class Solution2 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return res;
    }
}
