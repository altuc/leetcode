public class Solution {
    public int climbStairs(int n) {
        if(n <= 1) {
            return 1;
        }
        int[] total = new int[n];
        total[0] = 1;
        total[1] = 2;
        int step = 2;
        while(step < n) {
            total[step] = total[step-1] + total[step-2];
            step++;
        }
        return total[n-1];
    }
}