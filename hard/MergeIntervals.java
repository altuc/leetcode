/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.isEmpty()) {
            return res;
        }
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        Interval cur = intervals.get(0);
        int size = intervals.size();
        for(int i = 1; i < size; i++) {
            if(intervals.get(i).start > cur.end) {
                res.add(cur);
                cur = intervals.get(i);
            } else {
                cur.end = Math.max(cur.end, intervals.get(i).end);
            }
        }
        res.add(cur);
        return res;
    }
}
