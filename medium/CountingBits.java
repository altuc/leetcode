public class Solution {
    public int[] countBits(int num) {
        int pointer = 0;
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i = 1; i <= num; i++) {
            if((i & (i - 1)) == 0) {
                res[i] = 1;
                pointer = i;
            } else {
                if(i % 2 == 0) {
                    res[i] = res[pointer] + res[i - pointer];
                } else {
                    res[i] = res[i - 1] + 1;
                }
            }
        }
        return res;
    }
}
