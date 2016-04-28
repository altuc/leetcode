public class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length < 2) {
            return 0;
        }
        int max = 0;
        int[] w = new int[words.length];
        for(int i = 0; i < w.length; i++) {
            for(char c : words[i].toCharArray()) {
                w[i] |= 1 << c - 'a';
            }
        }
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if((w[i] & w[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
