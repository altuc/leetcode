public class Solution {
    public String getHint(String secret, String guess) {
        int[] sa = new int[10];
        int[] ga = new int[10];
        int bulls = 0, cows = 0;
        int len = secret.length();
        for(int i = 0; i < len; i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                sa[secret.charAt(i) - '0']++;
                ga[guess.charAt(i) - '0']++;
            }
        }
        for(int i = 0; i < 10; i++) {
            cows += Math.min(sa[i], ga[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
