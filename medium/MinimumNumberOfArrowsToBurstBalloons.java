public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (p1, p2) -> p1[0] - p2[0]);
        int[] cur = points[0];
        int res = 1, len = points.length;
        for(int i = 1; i < len; i++) {
            if(points[i][0] > cur[1]) {
                res++;
                cur = points[i];
            } else {
                cur[1] = Math.min(cur[1], points[i][1]);
            }
        }
        return res;
    }
}
