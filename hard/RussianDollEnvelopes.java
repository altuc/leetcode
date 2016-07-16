public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (e1, e2) -> e1[0] - e2[0]);
        int max = 1;
        int[] num = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++) {
            num[i] = 1;
            for(int j = 0; j < i; j++) {
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    num[i] = Math.max(num[i], num[j] + 1);
                }
            }
            max = Math.max(max, num[i]);
        }
        return max;
    }
}
