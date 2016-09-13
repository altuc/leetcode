/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null) {
            return 0;
        }
        if(points.length <= 2) {
            return points.length;
        }
        int res = 0;
        for(int i = 0; i < points.length - 1; i++) {
            int overlap = 0;
            int lineMax = 0;
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for(int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if(x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGcd(x, y);
                x /= gcd;
                y /= gcd;
                String slope = x + " " + y;
                int count = map.containsKey(slope) ? map.get(slope) + 1 : 1;
                map.put(slope, count);
                lineMax = Math.max(lineMax, count);
            }
            res = Math.max(res, lineMax + overlap + 1);
        }
        return res;
    }
    
    public int generateGcd(int x, int y) {
        if(y == 0) {
            return x;
        }
        return generateGcd(y, x % y);
    }
}
