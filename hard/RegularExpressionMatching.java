public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
        res[0][0] = true;
        for(int i = 1; i < res[0].length; i++) {
            if(p.charAt(i - 1) == '*') {
                res[0][i] = res[0][i - 2];
            }
        }
        for(int i = 1; i < res.length; i++) {
            for(int j = 1; j < res[0].length; j++) {
                if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    res[i][j] = res[i - 1][j - 1];
                } else {
                    if(p.charAt(j - 1) == '*') {
                        res[i][j] = res[i][j - 2];
                        if(p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                            res[i][j] |= res[i - 1][j];
                        }
                    }
                }
            }
        }
        return res[s.length()][p.length()];
    }
}
