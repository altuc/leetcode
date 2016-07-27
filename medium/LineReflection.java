public class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0) {
            return true;
        }
        HashSet<String> set = new HashSet<String>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            String p = point[0] + "x" + point[1] + "y";
            set.add(p);
        }
        long sum = min + max;
        for(int[] point : points) {
            if(!set.contains((sum - point[0]) + "x" + point[1] + "y")) {
                return false;
            }
        }
        return true;
    }
}
