public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int pos1 = -1;
        int pos2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1) && !words[i].equals(word2)) {
                pos1 = i;
                if(pos2 != -1) {
                    res = Math.min(res, pos1 - pos2);
                }
            }
            if(words[i].equals(word2) && !words[i].equals(word1)) {
                pos2 = i;
                if(pos1 != -1) {
                    res = Math.min(res, pos2 - pos1);
                }
            }
            if(words[i].equals(word1) && words[i].equals(word2)) {
                if(pos1 <= pos2) {
                    pos1 = i;
                } else {
                    pos2 = i;
                }
                if(pos1 != -1 && pos2 != -1) {
                    res = Math.min(res, Math.abs(pos2 - pos1));
                }
            }
        }
        return res;
    }
}
